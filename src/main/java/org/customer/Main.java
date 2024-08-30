package org.customer;

import org.product.controller.ProductController;
import org.product.repository.ProductRepository;
import org.product.service.ProductService;

/**
 * Class org.customer.Main
 * author Igor Novikov
 * 30.08.24
 */

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductService productService       = new ProductService(productRepository);
        ProductController productController = new ProductController(productService);
        productController.index();
    }
}
