package org.convertor.service;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factory extends Language {
    ConvertorInterface factory;
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorInterface handler()  {
        try {
            System.out.println(SELECT_POUNDS);
            System.out.println(SELECT_KGS);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    this.factory = new KgsToPounds();
                    break;
                case 2:
                    break;
                default:
                    System.out.println(INVALID_SELECT);
                    this.handler();
            }

        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            this.handler();
        }
        return this.factory;

    }
}
