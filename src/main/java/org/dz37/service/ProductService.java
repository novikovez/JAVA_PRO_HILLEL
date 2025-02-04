package org.dz37.service;

import org.dz37.entity.Product;
import org.dz37.repository.product.ProductRepository;
import org.dz37.repository.product.ProductRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository repository = new ProductRepositoryImpl();

    public void create(Product product) {
        repository.create(product);
    }

    public Product show(Long id) {
        return repository.getById(id).orElse(null);
    }

    public Optional<List<Product>> index() {
        return repository.getAll();
    }

    public void update(Product product) {
        repository.update(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
