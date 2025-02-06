package org.dz38;

import org.dz38.entity.Product;
import org.dz38.service.Cart;
import org.dz38.service.ProductService;
import org.dz38.utils.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        System.out.println("Start app..");
        Cart cart = context.getBean(Cart.class);
        ProductService productService = context.getBean(ProductService.class);

        Scanner scanner = new Scanner(System.in);
        Map<Long, Product> products = productService.getProducts();
        System.out.println("Products list");
        for (Product productEntity : products.values()) {
            System.out.println(productEntity);
        }
        System.out.println("Input the product id to add to the cart:");
        Long productId = scanner.nextLong();
        cart.add(productId);
        System.out.println("Product added to the cart:");
        for (Product productCart : cart.getProducts().values()) {
            System.out.println(productCart);
        }
        System.out.println("Input the ID for removing the product:");
        Long productIdRemove = scanner.nextLong();
        cart.remove(productIdRemove);
        System.out.println("Actual cart:");
        for (Product productCart : cart.getProducts().values()) {
            System.out.println(productCart);
        }
    }
}
