package org.dz37.service;

import org.dz37.entity.Order;
import org.dz37.repository.order.OrderRepository;
import org.dz37.repository.order.OrderRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private final OrderRepository repository = new OrderRepositoryImpl();

    public void create(Order order) {
        repository.create(order);
    }

    public Order show(Long id) {
        return repository.getById(id).orElse(null);
    }

    public Optional<List<Order>> index() {
        return repository.getAll();
    }

    public void update(Order order) {
        repository.update(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
