package org.shop_research;

/**
 * Class org.shop_research.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {

    public static void main(String[] args) {
        DataProvider provider = new DataProvider();
        DataHandler dataHandler = new DataHandler();

        String namesOutput = dataHandler.handleData(provider.getProductNames());
        getOutput("Products: " + namesOutput);

        String salesOutput = dataHandler.handleData(provider.getSalesAmounts());
        getOutput("Sales, EUR: " + salesOutput);
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
