package org.locker_app;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class org.locker_app.DataHandler
 * author Igor Novikov
 * 08.10.24
 */

public class DataHandler {
    private final Lock lock = new ReentrantLock();

    public synchronized int modify(int num) {
        lock.lock();
        try {
            num = num * 3;
            return num;
        } finally {
            lock.unlock();
        }
    }
}
