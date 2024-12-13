package org.dz28.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product", nullable = false)
    private String product;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public Long getId() {
        return id;
    }

    public Sales setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public Sales setProduct(String product) {
        this.product = product;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Sales setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Sales setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
