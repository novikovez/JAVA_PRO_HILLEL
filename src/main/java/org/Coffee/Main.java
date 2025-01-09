package org.Coffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.addOrder(new Order().setName("Test"));
        coffeeOrderBoard.addOrder(new Order().setName("Test 2"));
        coffeeOrderBoard.addOrder(new Order().setName("Test 3"));
        coffeeOrderBoard.deliver().getNumber();
        try {
            System.out.println(coffeeOrderBoard.deliver(55));
        } catch (NullDeliverId e) {
            LOGGER.info("Exception handling! - {}", e.getMessage());
        }
        coffeeOrderBoard.draw();
    }
}
