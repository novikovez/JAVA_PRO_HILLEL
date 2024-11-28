package org.dz24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Tests {
    public void testInstance() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Тест 1 пройдено: всі виклики getInstance() повертають один і той же екземпляр.");
        } else {
            System.err.println("Тест 1 провалено: getInstance() повертає різні екземпляри.");
        }
    }

    public void testLog() {
        String searchString = "Run testLog method";
        Logger logger1 = Logger.getInstance();
        logger1.log(searchString);
        String fileName = "log.txt";

        try {
            boolean found = Files.lines(Path.of(fileName))
                    .anyMatch(line -> line.contains(searchString));
            if (found) {
                System.out.println("Тест 2 пройдено.");
            } else {
                System.err.println("Тест 2 провалено");
            }
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}

