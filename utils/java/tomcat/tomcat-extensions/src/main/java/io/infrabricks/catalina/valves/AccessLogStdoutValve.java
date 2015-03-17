package io.infrabricks.catalina.valves;

import org.apache.catalina.valves.AbstractAccessLogValve;
import org.apache.catalina.LifecycleException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import java.io.CharArrayWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Log your access trafic to stdout
 * @author Peter Rossbach <peter.rossbach@bee42.com>
 */
public class AccessLogStdoutValve extends AbstractAccessLogValve {

  private static final Log log = LogFactory.getLog(AccessLogStdoutValve.class);

  /**
   * The Writer to which we are currently logging, if any.
   */
  protected PrintWriter writer = null;

    //------------------------------------------------------ Constructor
    public AccessLogStdoutValve() {
        super();
    }

    /**
     * Log the specified message to the log file, switching files if the date
     * has changed since the previous log call.
     *
     * @param message Message to be logged
     */
    @Override
    public void log(CharArrayWriter message) {

    // Log this message
      try {
        synchronized(this) {
          if (writer != null) {
            message.writeTo(writer);
            writer.println("");
            writer.flush();
          }
        }
      } catch (IOException ioe) {
        log.warn(sm.getString(
            "accessLogValve.writeFail", message.toString()), ioe);
      }
    }

    /**
     * Start this component and implement the requirements
     * of {@link org.apache.catalina.util.LifecycleBase#startInternal()}.
     *
     * @exception LifecycleException if this component detects a fatal error
     *  that prevents this component from being used
     */
    @Override
    protected synchronized void startInternal() throws LifecycleException {
      writer = new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            System.out)));
      super.startInternal();
    }

    /**
     * Stop this component and implement the requirements
     * of {@link org.apache.catalina.util.LifecycleBase#stopInternal()}.
     *
     * @exception LifecycleException if this component detects a fatal error
     *  that prevents this component from being used
     */
    @Override
    protected synchronized void stopInternal() throws LifecycleException {
      if (writer == null) {
            return;
      }
      writer.flush();
      writer.close();
      writer = null;
      super.stopInternal();
    }

}
