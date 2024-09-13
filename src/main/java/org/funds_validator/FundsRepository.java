package org.funds_validator;


import java.util.Random;

/**
 * Class org.funds_validator.FundsRepository
 * author Igor Novikov
 * 13.09.24
 */

public class FundsRepository extends FundsLanguage{

    private double balance;

    public FundsRepository() {
        Random rand = new Random();
        this.balance = rand.nextDouble() * 1000;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
