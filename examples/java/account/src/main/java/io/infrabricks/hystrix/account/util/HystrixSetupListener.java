package io.infrabricks.hystrix.account.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.configuration.AbstractConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.jmx.BaseConfigMBean;
import com.netflix.config.jmx.ConfigMBean;
import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.strategy.HystrixPlugins;

@WebListener
public class HystrixSetupListener implements ServletContextListener {

    private static Logger LOG = LoggerFactory
            .getLogger(HystrixSetupListener.class);

    /** for register and un-register. */
    static final String OBJ_NAME_LOG4J_BEAN =
            "io.infrabricks.archaius:type=ArchaiusMBean";

    /** Object name for JMX binding. */
    private ObjectName name;

    /**
     * Setup Servo and other Hystrix elements, and JMX Registration of Archaius.
     *
     * @param sce
     *            servlet context event
     */
    public void contextInitialized(ServletContextEvent sce) {
        AbstractConfiguration conf = ConfigurationManager.getConfigInstance();

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // register Archaius as MBean to allow runtime configuration.
        try {
            name =
                    new ObjectName(OBJ_NAME_LOG4J_BEAN
                            + sce.getServletContext().getContextPath());
            BaseConfigMBean bean = new BaseConfigMBean(conf);
            StandardMBean mbean = new StandardMBean(bean, ConfigMBean.class);
            mbs.registerMBean(mbean, name);
        } catch (InstanceAlreadyExistsException | MalformedObjectNameException
                | NotCompliantMBeanException | MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }

        // expose all Hystrix methods as JMX Beans
        //HystrixPlugins.getInstance().registerMetricsPublisher(
          //HystrixServoMetricsPublisher.getInstance());

    }


    /**
     * Cleanup JMX Registration of Archaius.
     *
     * @param sce
     *            servlet context event
     */
    public void contextDestroyed(ServletContextEvent sce) {

        // de-register Archaius MBean
        if (name != null) {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            try {
                mbs.unregisterMBean(name);
            } catch (MBeanRegistrationException | InstanceNotFoundException e) {
                LOG.info("problem de-registering " + e);
            }
        }

        // tag::hystrixstop[]
        // shutdown all thread pools; waiting a little time for shutdown
        Hystrix.reset(1, TimeUnit.SECONDS);
        // end::hystrixstop[]

        // tag::archaiusstop[]
        // shutdown configuration listeners that might have been activated by
        // Archaius
        if (ConfigurationManager.getConfigInstance() instanceof DynamicConfiguration) {
            ((DynamicConfiguration) ConfigurationManager.getConfigInstance())
                    .stopLoading();
        } else if (ConfigurationManager.getConfigInstance() instanceof ConcurrentCompositeConfiguration) {
            ConcurrentCompositeConfiguration config =
                    ((ConcurrentCompositeConfiguration) ConfigurationManager
                            .getConfigInstance());
            for (AbstractConfiguration innerConfig : config.getConfigurations()) {
                if (innerConfig instanceof DynamicConfiguration) {
                    ((DynamicConfiguration) innerConfig).stopLoading();
                }
            }
        }
        // end::archaiusstop[]

    }
}
