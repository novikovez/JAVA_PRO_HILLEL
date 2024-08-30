package org.product.repository;

/**
 * Class org.product.repository.ProductDTO
 * author Igor Novikov
 * 30.08.24
 */

public class ProductDTO {
    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final int quantity;
    private double total;
    private double cost;

    public ProductDTO(
            int id,
            String name,
            String description,
            double price,
            int quantity
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
