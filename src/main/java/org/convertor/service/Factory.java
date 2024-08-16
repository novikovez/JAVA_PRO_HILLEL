package org.convertor.service;


/*
| Автор: Igor Novikov |
*/

import org.convertor.language.Language;
import org.convertor.service.distance.MilesToKm;
import org.convertor.service.weight.KgsToPounds;
import org.convertor.service.weight.PoundsToKgs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factory extends Language {
    ConvertorInterface factory;
    private static final Scanner scanner = new Scanner(System.in);

    public ConvertorInterface handler()  {
        this.selectType();
        return this.factory;
    }

    private void selectType() {
        try {
            System.out.println(SELECT_TYPE);
            System.out.println(SELECT_TYPE_1);
            System.out.println(SELECT_TYPE_2);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    this.selectDistance();
                    break;
                case 2:
                    this.selectWeight();
                    break;
                default:
                    System.out.println(INVALID_SELECT);
                    this.selectType();
            }
        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            this.selectType();
        }

    }

    private void selectDistance() {
        try {
            System.out.println(SELECT_MILES);
            System.out.println(SELECT_KM);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    this.factory = new MilesToKm();
                    break;
                case 2:
                   //
                    break;
                default:
                    System.out.println(INVALID_SELECT);
                    this.selectDistance();
            }

        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            this.selectDistance();
        }
    }

    private void selectWeight() {
        try {
            System.out.println(SELECT_POUNDS);
            System.out.println(SELECT_KGS);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    this.factory = new PoundsToKgs();
                    break;
                case 2:
                    this.factory = new KgsToPounds();
                    break;
                default:
                    System.out.println(INVALID_SELECT);
                    this.selectWeight();
            }

        } catch (InputMismatchException e) {
            System.out.println(INVALID_INPUT);
            scanner.nextLine();
            this.selectWeight();
        }
    }
}
