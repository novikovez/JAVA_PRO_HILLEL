package org.names_map;


/**
 * Class org.names_list.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {
    public static void main(String[] args) {
        DataHandler handler = new DataHandler();
        UIOperator uiOperator = new UIOperator();
        uiOperator.getOutput(handler.getAll());
        uiOperator.getOutput(handler.getById(172));
    }
}
