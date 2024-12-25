package org.dz30.dao;

import org.dz30.entity.Homework;
import org.dz30.entity.Student;
import org.dz30.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HomeworkDao {

    public void save(Homework entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
    }

    public Homework findById(Long aLong) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Homework homework = session.find(Homework.class, aLong);
            session.getTransaction().commit();
            return homework;

        }
    }

    public List<Homework> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Homework> homeworks = session.createQuery("FROM Homework", Homework.class).getResultList();
            session.getTransaction().commit();
            return homeworks;
        }
    }

    public Homework update(Homework entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Homework homework = session.merge(entity);
            session.getTransaction().commit();
            return homework;
        }
    }

    public boolean deleteById(Long aLong) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Homework homework = findById(aLong);
            if(homework != null) {
                session.remove(homework);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }

    }
}
