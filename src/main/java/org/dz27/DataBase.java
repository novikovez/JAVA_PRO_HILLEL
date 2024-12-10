package org.dz27;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DataBase {
    private final SessionFactory sessionFactory;
    private final Session session;

    public DataBase() {
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public <T> void store(T object) {
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
    }

    public <T> List<T> index(Class<T> clazz) {
        session.beginTransaction();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public <T> void destroy(T object) {
        session.beginTransaction();
        session.remove(object);
        session.getTransaction().commit();
    }

    public void close() {
        this.sessionFactory.close();
        this.session.close();
    }
}
