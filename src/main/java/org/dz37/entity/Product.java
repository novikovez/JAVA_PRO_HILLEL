package org.dz37.dto;

public class Product {
    private Integer id;
    private String name;
    private double cost;

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double price) {
        this.cost = price;
    }
}
