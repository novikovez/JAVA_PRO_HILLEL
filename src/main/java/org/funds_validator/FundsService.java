package org.funds_validator;


/**
 * Class org.funds_validator.FundsService
 * author Igor Novikov
 * 13.09.24
 */

public class FundsService extends FundsLanguage {

    private final FundsRepository fundsRepository;

    public FundsService() {
        this.fundsRepository = new FundsRepository();
    }

    public double getBalance() {
        return fundsRepository.getBalance();
    }

    public String transaction(double value) throws FundsException {
        StringBuilder stringBuilder = new StringBuilder();
        double balance = this.getBalance() - value;
        if(balance < 0) {
            throw new FundsException(INS);
        }
        this.fundsRepository.setBalance(balance);
        stringBuilder.append(String.format(FOUND + BALANCE, balance));
        return stringBuilder.toString();
    }
}
