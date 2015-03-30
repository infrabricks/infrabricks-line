package io.infrabricks.hystrix.account.base;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.infrabricks.hystrix.account.rest.HystrixSaveAccount;
import io.infrabricks.hystrix.account.rest.SimpleSaveAccount;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

// tag::classdef[]
@ApplicationPath("/api")
public class HystrixApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    private static Logger LOG = LoggerFactory
            .getLogger(HystrixApplication.class);

    public HystrixApplication() {
      dbmigration();
      singletons.add(new SimpleSaveAccount());
      singletons.add(new HystrixSaveAccount());
      singletons.add(new ValidationExceptionMapper());
      singletons.add(new InterruptedExceptionMapper());
    }

    private static void dbmigration() {
      // Create the Flyway instance
      Flyway flyway = new Flyway();
      flyway.setInitOnMigrate(true);
      // Point it to the database
      flyway.setDataSource(
        "jdbc:mysql://mysql:3306/bank", System.getenv("MYSQL_USER"),
        System.getenv("MYSQL_PASSWORD"));
      // Start the migration
      for (MigrationInfo i : flyway.info().all()) {
        LOG.info("migrate task: {} : {} from file: {}",
          i.getVersion(), i.getDescription(), i.getScript());
      }
      flyway.migrate();
    }

    @Override
    public Set<Object> getSingletons() {
      return singletons;
    }
}
// end::classdef[]
