package org.dz38.service;

import org.dz38.entity.Product;
import org.dz38.repository.product.ProductRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ProductService {
    ProductRepositoryImpl productRepository;

    public ProductService(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Long, Product> getProducts() {
        Optional<Map<Long, Product>> optionalProducts = this.productRepository.findAll();
        if(optionalProducts.isPresent()) {
            return optionalProducts.get();
        }
        throw new IllegalStateException("No products found");
    }







}
