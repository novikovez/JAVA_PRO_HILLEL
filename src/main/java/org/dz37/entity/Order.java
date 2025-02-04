package org.dz37.dto;

import java.util.List;

public class Order {
    private int id;
    private String date;
    private double cost;
    private List<Product> products;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product>  products) {
        this.products = products;
    }
}
