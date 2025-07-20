package org.demo.locks.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTester {
    public static void main(String[] args) {

        Lock l1 = new ReentrantLock(true);
        Lock l2 = new ReentrantLock(true);

        CommonResource commonResource1 = new CommonResource(5, l1);
        CommonResource commonResource2 = new CommonResource(10, l2);

        Thread t1 = new Thread(()->{
            commonResource1.getLock().lock();
            System.out.println("Inside Thread "+Thread.currentThread().getName()+" acquired lock for "+commonResource1);
            commonResource2.getLock().lock();
            System.out.println("Inside Thread "+Thread.currentThread().getName()+" acquired lock for "+commonResource2);
            int sum = commonResource1.getVal()+ commonResource2.getVal();
            System.out.println("Sum of value "+sum);
            commonResource2.getLock().unlock();
            commonResource1.getLock().unlock();
        },"T1");

        Thread t2 = new Thread(()->{
            commonResource2.getLock().lock();
            System.out.println("Inside Thread "+Thread.currentThread().getName()+" acquired lock for "+commonResource2);
            commonResource1.getLock().lock();
            System.out.println("Inside Thread "+Thread.currentThread().getName()+" acquired lock for "+commonResource1);
            int left = commonResource1.getVal()- commonResource2.getVal();
            System.out.println("Subtraction of value "+left);
            commonResource1.getLock().unlock();
            commonResource2.getLock().unlock();
        },"T2");

        t1.start();
        t2.start();
    }
}
