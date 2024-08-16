package org.convertor.service.distance;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import org.convertor.service.ConverterTypeInterface;
import org.convertor.service.ConvertorServiceInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DistanceFactory extends Language implements ConverterTypeInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorServiceInterface getFactory() {
        try {
            System.out.println(SELECT_MILES);
            System.out.println(SELECT_KM);
            int input = scanner.nextInt();
            return switch (input) {
                case 1 -> new MilesToKm();
                case 2 -> new KmToMiles();
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
