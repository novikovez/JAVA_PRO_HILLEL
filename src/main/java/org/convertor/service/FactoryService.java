package org.convertor.service;

/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import org.convertor.service.distance.DistanceFactory;
import org.convertor.service.temperature.TemperatureFactory;
import org.convertor.service.weight.WeightFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FactoryService extends Language {
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorServiceInterface handler()  {
        try {
            System.out.println(SELECT_TYPE);
            System.out.println(SELECT_TYPE_1);
            System.out.println(SELECT_TYPE_2);
            System.out.println(SELECT_TYPE_3);
            int input = scanner.nextInt();
            return switch (input) {
                case 1 -> new DistanceFactory().getFactory();
                case 2 -> new WeightFactory().getFactory();
                case 3 -> new TemperatureFactory().getFactory();
                default -> {
                    throw new InputMismatchException();
                }
            };
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            return this.handler();
        }
    }

}
