package org.Coffee;

public class Order {
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public Order setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }
}
