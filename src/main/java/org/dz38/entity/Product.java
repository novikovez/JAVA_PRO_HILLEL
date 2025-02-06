package org.dz38.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Product |" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '|';
    }
}
