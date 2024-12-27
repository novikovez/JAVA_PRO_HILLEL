package org.dz30.dao;

import org.dz30.entity.Student;
import org.dz30.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentDao implements GenericDao<Student, Long> {
    @Override
    public void save(Student entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public Student findById(Long aLong) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, aLong);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student findByEmail(String email) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.createQuery("FROM Student WHERE email = :email", Student.class)
                    .setParameter("email", email)
                    .getSingleResult();
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public Student update(Student entity) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public boolean deleteById(Long aLong) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = findById(aLong);
            if(student != null) {
                session.remove(student);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }
}
