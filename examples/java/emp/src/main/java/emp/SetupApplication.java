package emp;

import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import java.lang.ClassNotFoundException;

@WebListener
public class SetupApplication implements ServletContextListener{
  public void contextInitialized(ServletContextEvent contextEvent) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver registered");
    }
    catch (ClassNotFoundException ex) {
      System.out.println("MYSQL Driver not found!");
    }
    // Create the Flyway instance
    Flyway flyway = new Flyway();
    flyway.setBaselineOnMigrate(true);
    // Point it to the database
    flyway.setDataSource(
      "jdbc:mysql://mysql:3306/" +
      System.getenv("MYSQL_DATABASE"),
      System.getenv("MYSQL_USER"),
      System.getenv("MYSQL_PASSWORD"));
    // Start the migration
    for (MigrationInfo i : flyway.info().all()) {
      System.out.printf("migrate task: %s : %s from file: $s\n",
        i.getVersion(),
        i.getDescription(),
        i.getScript());
    }
    flyway.migrate();

  }

  public void contextDestroyed(ServletContextEvent contextEvent) {}

}
