package org.convertor.service.weight;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import org.convertor.service.ConverterTypeInterface;
import org.convertor.service.ConvertorServiceInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeightFactory extends Language implements ConverterTypeInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorServiceInterface getFactory() {
        try {
            System.out.println(SELECT_POUNDS);
            System.out.println(SELECT_KGS);
            int input = scanner.nextInt();
            return switch (input) {
                case 1 -> new PoundsToKgs();
                case 2 -> new KgsToPounds();
                default -> {
                    throw new InputMismatchException();
                }
            };
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            return this.getFactory();
        }
    }
}
