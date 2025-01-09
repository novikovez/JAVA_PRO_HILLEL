package org.Coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders = new ArrayList<>();
    private int nextOrderId;
    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
        this.nextOrderId = 1;
        LOGGER.info("CoffeeOrderBoard initialization class");
    }

    public void addOrder(Order order) {
        order.setNumber(nextOrderId);
        orders.add(order);
        LOGGER.info("CoffeeOrderBoard.addOrder method add order with number {}", nextOrderId);
        nextOrderId++;
    }

    public Order deliver() {
        orders.reversed();
        LOGGER.info("CoffeeOrderBoard.deliver show and remove first order");
        return orders.removeFirst();
    }

    public Order deliver(int number) {
        try {
            for (Order order : orders) {
                if (order.getNumber() == number) {
                    orders.remove(order);
                    LOGGER.info("CoffeeOrderBoard.deliver show and remove {} order", number);
                    return order;
                }
            }
            throw new NullDeliverId("Order with number " + number + " not found");
        } catch (NullDeliverId e) {
            LOGGER.error("Error occurred while trying to deliver the order: {}", e.getMessage(), e);
            throw e; // Повторно кидаємо виняток для коректної обробки
        }
    }

    public void draw() {
        LOGGER.info("CoffeeOrderBoard.draw show all orders");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
    }
}
