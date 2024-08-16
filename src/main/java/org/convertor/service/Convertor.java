package org.convertor.service;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Convertor extends Language  {
    private static final Scanner scanner = new Scanner(System.in);

    public void handler()  {
        FactoryService factory = new FactoryService();
        ConvertorServiceInterface convertorInterface = factory.handler();

        try {
            System.out.println(INPUT);
            double result = convertorInterface.handler(scanner.nextDouble());
            System.out.println(result);
        } catch (InputMismatchException e) {
            scanner.nextLine();
            this.handler();
        }
    }

}
