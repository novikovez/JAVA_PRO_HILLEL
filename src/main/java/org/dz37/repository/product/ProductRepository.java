package org.dz37.repository.order;

import org.dz37.entity.Order;
import org.dz37.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends BaseRepository<Order> {
    void create(Order obj);
    Optional<List<Order>> getAll();
    Optional<Order> getById(Long id);
    void update(Order obj);
    void deleteById(Long id);
}
