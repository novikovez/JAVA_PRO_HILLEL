package org.dz37.repository.order;

import org.dz37.config.Hibernate;
import org.dz37.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void create(Order obj) {
        Transaction transaction = null;
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
//            String hql = "INSERT INTO Order (date, cost, products) " +
//                    "VALUES (:date, :cost, :products)";
//            MutationQuery query = session.createMutationQuery(hql);
//            query.setParameter("date", obj.getDate());
//            query.setParameter("cost", obj.getCost());
//            query.setParameter("products", obj.getProducts());
//            query.executeUpdate();
            session.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<List<Order>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Order> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Order obj) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
