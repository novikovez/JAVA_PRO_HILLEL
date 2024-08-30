package org.product.service;


import org.product.repository.ProductDTO;

/**
 * Class org.product.service.CalcCostDeliveryService
 * author Igor Novikov
 * 30.08.24
 */

public class CalcCostDeliveryService {
    private final static double deliveryPrice = 7.00;

    public ProductDTO calcCost(
            ProductDTO product
    ) {
        double total = product.getTotal() + deliveryPrice;
        product.setCost(total);
        return product;
    }
}
