package org.demo.locks.readWriteLock;

public class ReadWriteLockTester {

    public static void main(String[] args) {
        CountingResource countingResource = new CountingResource();

        Thread t1 = new Thread(()->{
            for(int i = 0;i<10;i++){
                try {
                    countingResource.increment();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for(int i = 0;i<12;i++){
                try {
                    countingResource.display();
                    Thread.sleep(100);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        },"t2");

        Thread t3 = new Thread(()->{
            for(int i = 0;i<12;i++){
                try {
                    countingResource.display();
                    Thread.sleep(100);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        },"t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
