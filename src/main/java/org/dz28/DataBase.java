package org.dz28;

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

    public <T> List<T> index(Class<T> clazz, int limit, int offset) {
        session.beginTransaction();
        List<T> resultList = session.createQuery("FROM " + clazz.getSimpleName(), clazz)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    public <T> Double getSum(Class<T> clazz, String field) {
        session.beginTransaction();
        Double sum = session.createQuery("SELECT SUM(" + field + ") FROM " + clazz.getSimpleName(), Double.class)
                .getSingleResult();
        session.getTransaction().commit();
        return sum != null ? sum : 0.0;
    }

    public List<Object[]> rawGroupBy(String tableName, String groupByField, String countField, String avgField) {
        session.beginTransaction();
        String sql = String.format(
                "SELECT %s, COUNT(%s) AS total_quantity, AVG(%s) AS average_price " +
                        "FROM %s GROUP BY %s",
                groupByField, countField, avgField, tableName, groupByField
        );
        List<Object[]> results = session.createNativeQuery(sql).getResultList();
        session.getTransaction().commit();
        return results;
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
