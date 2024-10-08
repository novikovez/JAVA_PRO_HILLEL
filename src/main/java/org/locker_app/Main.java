package org.locker_app;

/**
 * Class org.locker_app.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {
    public static void main(String[] args) {
        int[] numbers = new DataRepository().getData();
        DataHandler dataHandler = new DataHandler();
        for (int num : numbers) {
            System.out.println("Initial value is " + num);
            int newNum = dataHandler.modify(num);
            System.out.println("New value is " + newNum);
        }
    }
}
