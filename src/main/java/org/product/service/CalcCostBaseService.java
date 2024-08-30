package org.product.service;


import org.product.repository.ProductDTO;

/**
 * Class org.product.service.CalcCostBaseService
 * author Igor Novikov
 * 30.08.24
 */

public class CalcCostBaseService {

    public ProductDTO calcCost(
            ProductDTO product
    ) {
        double total = product.getQuantity() * product.getPrice();
        product.setTotal(total);
        return product;
    }
}
