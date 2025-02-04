package org.dz37.repository.product;

import org.dz37.entity.Order;
import org.dz37.entity.Product;
import org.dz37.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends BaseRepository<Product> {
    void create(Product obj);
    Optional<List<Product>> getAll();
    Optional<Product> getById(Long id);
    void update(Product obj);
    void deleteById(Long id);
}
