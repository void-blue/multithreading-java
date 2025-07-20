package org.demo.locks.deadlock;

import java.util.concurrent.locks.Lock;

public class CommonResource {
    private int val;
    private Lock lock;

    public CommonResource(int val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    public int getVal() {
        return val;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "CommonResource{" +
                "val=" + val +
                '}';
    }
}
