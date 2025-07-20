package org.demo.locks.basicLock;

import java.util.concurrent.locks.Lock;

public class BankApplication {
    private int balance;
    private Lock lock;

    public BankApplication(int balance, Lock lock) {
        this.balance = balance;
        this.lock = lock;
    }

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" entered for withdrawl of "+amount);
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" acquired Lock ");
        try {
            if(balance>=amount){

                Thread.sleep(1000);
                balance = balance-amount;
                System.out.println(Thread.currentThread().getName()+" Withdrew amount "+amount+" remaining balance "+balance);
            }
            else{
                System.out.println(Thread.currentThread().getName()+" cannot withdraw "+amount+" balance insufficient "+balance);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
