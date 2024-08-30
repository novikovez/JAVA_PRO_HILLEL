package org.product.controller;


import org.product.language.ProductLanguage;
import org.product.repository.ProductDTO;
import org.product.service.ProductService;

import java.util.List;

/**
 * Class org.product.controller.ProductController
 * author Igor Novikov
 * 30.08.24
 */

public class ProductController extends ProductLanguage {
    private final ProductService productService;

    public ProductController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    public void index() {
        List<ProductDTO> items = this.productService.index();
        System.out.println(LINE);
        for (ProductDTO item : items) {
            System.out.printf(PRODUCT, item.getName(), item.getQuantity(), item.getPrice());
            System.out.printf(COST, item.getTotal());
            System.out.printf(COST_DELIVERY, item.getCost());
            System.out.println(LINE);
        }

    }
}
