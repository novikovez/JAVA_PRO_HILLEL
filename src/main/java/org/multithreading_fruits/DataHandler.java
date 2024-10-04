package org.multithreading_fruits;


import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

/**
 * Class org.multithreading_fruits.DataHandler
 * author Igor Novikov
 * 04.10.24
 */

public class DataHandler {
    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        // критичний блок коду
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            AtomicInteger count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.getAndIncrement(), fruit));
            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}
