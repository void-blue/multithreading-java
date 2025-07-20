package org.demo.ProducerConsumer.solution;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferUtility {

    private boolean hasData;
    private int val;
    Lock lock;

    public BufferUtility() {
        hasData = false;
        val = 0;
        lock = new ReentrantLock();
    }

    public synchronized void produce() throws InterruptedException {
       while(hasData){
            wait();
       }

       hasData = true;
       val = new Random().nextInt(100);
        System.out.println("From "+Thread.currentThread().getName()+" produced "+val);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while(!hasData){
            wait();
        }


        hasData = false;
        int item = val;
        val = 0;
        System.out.println("From "+Thread.currentThread().getName()+" consumed "+item);
        notifyAll();
    }
}
