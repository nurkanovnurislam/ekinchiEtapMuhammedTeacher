package peaksoft.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.*;

import java.util.Properties;

public class Config {
    public static SessionFactory getSessionFactory() {
        Properties p = new Properties();
        p.put(Environment.DRIVER,"org.postgresql.Driver");
        p.put(Environment.URL,"jdbc:postgresql://localhost:5432/exam");
        p.put(Environment.USER,"postgres");
        p.put(Environment.PASS,"");
        p.put(Environment.SHOW_SQL,"true");
        p.put(Environment.HBM2DDL_AUTO,"create");
        p.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQL9Dialect");

        Configuration c = new Configuration();
        c.addAnnotatedClass(Car.class);
        c.addAnnotatedClass(Company.class);
        c.addAnnotatedClass(Garage.class);
        c.addAnnotatedClass(Person.class);
        c.addAnnotatedClass(Social.class);

        c.addProperties(p);

        return c.buildSessionFactory();
    }
    public static EntityManager getConnection() {
        return Persistence.createEntityManagerFactory("java").createEntityManager();
    }
}
