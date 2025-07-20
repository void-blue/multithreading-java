package org.demo.locks.basicLock;

import java.util.concurrent.locks.ReentrantLock;

public class BankApplicationUser {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication(100,new ReentrantLock());

        Thread t1 = new Thread(()->{
            bankApplication.withdraw(60);
        },"T1");

        Thread t2 = new Thread(()->{
            bankApplication.withdraw(60);
        },"T2");

        t1.start();
        t2.start();

    }
}
