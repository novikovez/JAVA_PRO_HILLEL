package org.dz17;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class org.dz17.DataProvider
 * author Igor Novikov
 * 25.10.24
 */

public class DataProvider {

    public List<Product> dataProviders() {
        return Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );
    }
}
