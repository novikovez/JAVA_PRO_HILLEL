package org.dz32.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static final String HIBERNATE_CFG_FILE = "hibernate.properties";

    private static SessionFactory sessionFactory() {
        SessionFactory newSessionFactory = null;
        try {

            Properties hibernateProperties = new Properties();
            hibernateProperties.load(HibernateUtil.class.getClassLoader().getResourceAsStream(HIBERNATE_CFG_FILE));

            newSessionFactory = new Configuration()
                    .addProperties(hibernateProperties)
                    .addAnnotatedClass(org.dz32.Book.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Config Error!" + e.getMessage());
        }
        return newSessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory();
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
