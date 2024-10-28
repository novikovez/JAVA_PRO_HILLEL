package org.dz17;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class org.dz17.Main
 * author Igor Novikov
 * 25.10.24
 */

public class Main
{
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        List<Product> products = dataProvider.dataProviders();
        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        Map.Entry<String, Double> maxEntry = Collections.max(result.entrySet(), Map.Entry.comparingByValue());
        System.out.println("Result: " + result);
        System.out.println("Max AVG: " + maxEntry.getKey());

    }
}
