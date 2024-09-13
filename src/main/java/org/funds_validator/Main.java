package org.funds_validator;

/**
 * Class org.funds_validator.Main
 * author Igor Novikov
 * 30.08.24
 */

public class Main extends FundsLanguage {

    static FundsController controller = new FundsController();

    public static void main(String[] args) {
         System.out.printf(BALANCE, controller.balance());
         System.out.println(ENTER);
         System.out.println(controller.transaction());
    }
}
