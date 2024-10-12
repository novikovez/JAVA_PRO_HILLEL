package org.names_list;

import org.locker_app.DataHandler;
import org.locker_app.DataRepository;

/**
 * Class org.names_list.Main
 * author Igor Novikov
 * 17.09.24
 */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>();
        test.add("String 1");
        test.add("String 2");

        System.out.println("Item 1: " + test.get(0));
        System.out.println("Item 2: " +test.get(1));

        System.out.println("Size: " + test.size());
        System.out.println("Destroy Item: " + test.destroy(1));
        test.add("String 2");
        test.add("String 3");
        System.out.println("Size: " + test.size());
        test.add(2,"String Insert");
        System.out.println("String: " + test.toString());
    }
}
