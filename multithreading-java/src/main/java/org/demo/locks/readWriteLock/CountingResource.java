package org.demo.locks.readWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CountingResource {

    private int counter;
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock readLock = rwl.readLock();
    private Lock writeLock = rwl.writeLock();

    public CountingResource() {
        counter = 0;
    }

    public void increment() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName()+" Entered writing section ");
        counter++;
        writeLock.unlock();

    }

    public void display(){
        readLock.lock();
        System.out.println(Thread.currentThread().getName()+" Entered displaying section ");
        System.out.println(Thread.currentThread().getName()+" value after increment "+counter);
        readLock.unlock();
    }


}
