package org.funds_validator;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class org.funds_validator.FundsController
 * author Igor Novikov
 * 13.09.24
 */

public class FundsController extends FundsLanguage {

    private final FundsService fundsService;
    private final Scanner scanner = new Scanner(System.in);

    public FundsController() {
        this.fundsService = new FundsService();
    }

    public double balance() {
        return this.fundsService.getBalance();
    }

    public String transaction() {
        try {
            double balance = scanner.nextDouble();
            return this.fundsService.transaction(balance);
        } catch (InputMismatchException $e) {
            return NOT_NUMBER;
        } catch (FundsException e) {
            return e.getMessage();
        }
    }
}
