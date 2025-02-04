package org.dz37.config;

import org.dz37.entity.Order;
import org.dz37.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate {
    private static final String HIBERNATE_CFG_FILE = "hibernate.properties";
    private static SessionFactory sessionFactory;

    static {
        try {
            Properties hibernateProperties = new Properties();
            hibernateProperties.load(Hibernate.class.getClassLoader().getResourceAsStream(HIBERNATE_CFG_FILE));

            sessionFactory = new Configuration()
                    .addProperties(hibernateProperties)
                    .addAnnotatedClass(Order.class)
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Config Error!" + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}


