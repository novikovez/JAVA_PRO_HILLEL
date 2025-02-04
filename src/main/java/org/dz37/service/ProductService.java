package org.dz37.service;

import org.dz37.entity.Order;
import org.dz37.repository.order.OrderRepository;
import org.dz37.repository.order.OrderRepositoryImpl;

public class OrderService {
    private final OrderRepository repository = new OrderRepositoryImpl();

    public void create(Order order) {
        repository.create(order);
    }
}
