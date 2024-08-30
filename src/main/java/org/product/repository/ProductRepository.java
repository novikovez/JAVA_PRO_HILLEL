package org.product.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class org.product.repository.ProductRepository
 * author Igor Novikov
 * 30.08.24
 */

public class ProductRepository {
    Random random = new Random();
    public List<ProductDTO> dtos = new ArrayList<>();

    public List<ProductDTO> getData() {
        for (int i = 0; i < 10; i++) {
            dtos.add(new ProductDTO(
                    random.nextInt(10) + 1,
                    this.randName(),
                    this.randEmail(),
                    random.nextDouble(1000),
                    random.nextInt(10) + 1
                    )
            );
        }
        return dtos;
    }

    private String randName() {
       String[] array = {
               "TV",
               "Telephone",
               "Radio",
               "Notebook",
               "Monitor",
       };
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }

    private String randEmail() {
        String[] array = {
                "mail1@example.com",
                "goo@gmail.com",
                "lol@mail.com",
                "kila@lola.com",
                "tech@hio.net",
        };
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }
}
