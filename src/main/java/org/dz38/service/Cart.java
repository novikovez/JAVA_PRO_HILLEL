package org.dz38.service;

import org.dz38.entity.Product;
import org.dz38.repository.product.ProductRepositoryImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    private Map<Long, Product> products = new HashMap<>();
    private final ProductRepositoryImpl productRepository;

    public Cart(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public void add(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            this.products.put(productId, product.get());
            return;
        }
        throw new IllegalArgumentException("Product not found");
    }

    public void remove(Long productId) {
        if(this.products.containsKey(productId)) {
            this.products.remove(productId);
            return;
        }
        throw new IllegalArgumentException("Product not found");
    }

    public Map<Long, Product> getProducts() {
        return products;
    }

}
