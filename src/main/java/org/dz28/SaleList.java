package org.dz28;

import org.dz28.entity.Sales;

import java.util.ArrayList;
import java.util.List;

public class SaleList {
    private final List<Sales> data = new ArrayList<>();
    private final DataBase dataBase;

    public SaleList() {
        this.dataBase = new DataBase();
    }

    public void add(
            String product,
            double price,
            int quantity
    ) {
        data.add(new Sales()
                .setProduct(product)
                .setPrice(price)
                .setQuantity(quantity)
        );
    }

    public List<Sales> getData() {
        return data;
    }

    public void saveDataBase() {
        for (Sales sales : this.data) {
            dataBase.store(sales);
        }
    }
}
