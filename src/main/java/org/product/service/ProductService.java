package org.product.service;


import org.product.repository.ProductDTO;
import org.product.repository.ProductRepository;

import java.util.List;

/**
 * Class org.product.service.ProductService
 * author Igor Novikov
 * 30.08.24
 */

public class ProductService {
    private final ProductRepository productRepository;
    private final CalcCostBaseService calcCostBaseService =  new CalcCostBaseService();
    private final CalcCostDeliveryService calcCostDeliveryService = new CalcCostDeliveryService();

    public ProductService(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> index() {
        List<ProductDTO> data = this.productRepository.getData();
        for (int i = 0; i < data.size(); i++) {
            ProductDTO dto = data.get(i);
            data.set(i, this.calcCostBaseService.calcCost(dto));
            data.set(i, this.calcCostDeliveryService.calcCost(dto));
        }

        return data;
    }
}
