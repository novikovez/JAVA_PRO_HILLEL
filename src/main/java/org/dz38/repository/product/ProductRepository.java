package org.dz38.repository.product;

import org.dz38.entity.Product;
import org.dz38.repository.BaseRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository extends BaseRepository<Product, Long> {
    void create(Product entity);
    void update(Product entity);
    Optional<Product> findById(Long id);
    Optional<Map<Long, Product>> findAll();
    void deleteById(Long id);
}
