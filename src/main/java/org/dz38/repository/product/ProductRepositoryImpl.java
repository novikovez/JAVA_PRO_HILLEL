package org.dz38.repository.product;

import org.dz38.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Qualifier("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
    private final Map<Long, Product> products;

    public ProductRepositoryImpl() {
        this.products =  Stream.of(
                new Product().setId(1L).setName("Product 1").setPrice(10.2),
                new Product().setId(2L).setName("Product 2").setPrice(11.2),
                new Product().setId(3L).setName("Product 3").setPrice(22.2)
        ).collect(Collectors.toMap(Product::getId, p -> p));
    }

    @Override
    public void create(Product entity) {
        if(products.putIfAbsent(entity.getId(), entity) != null) {
            throw new RuntimeException("Product with id " + entity.getId() + " already exists");
        }
    }

    @Override
    public void update(Product entity) {
        this.products.put(entity.getId(), entity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(this.products.get(id));
    }

    @Override
    public Optional<Map<Long, Product>> findAll() {
        return Optional.of(this.products);
    }

    @Override
    public void deleteById(Long id) {
        this.products.remove(id);
    }
}
