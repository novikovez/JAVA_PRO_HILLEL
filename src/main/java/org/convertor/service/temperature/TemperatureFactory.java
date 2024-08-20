package org.convertor.service.temperature;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import org.convertor.service.ConverterTypeInterface;
import org.convertor.service.ConvertorServiceInterface;
import org.convertor.service.weight.KgsToPounds;
import org.convertor.service.weight.PoundsToKgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureFactory extends Language implements ConverterTypeInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorServiceInterface getFactory() {
        try {
            System.out.println(SELECT_T_FR_C);
            System.out.println(SELECT_T_C_FR);
            int input = scanner.nextInt();
            return switch (input) {
                case 1 -> new FrToCe();
                case 2 -> new CeToFr();
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
