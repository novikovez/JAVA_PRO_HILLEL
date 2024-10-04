package org.multithreading_fruits;


/**
 * Class org.multithreading_fruits.MyThread
 * author Igor Novikov
 * 04.10.24
 */

public class MyThread extends Thread {
    DataHandler dataHandler;

    public MyThread(String name, DataHandler dataHandler) {
        super(name);
        this.dataHandler = dataHandler;
    }

    public void run() {
        dataHandler.getOutput();
    }

}
