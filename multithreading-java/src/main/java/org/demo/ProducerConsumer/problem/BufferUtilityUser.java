package org.demo.ProducerConsumer.problem;

public class BufferUtilityUser {
    public static void main(String[] args) {
        final BufferUtility bu = new BufferUtility();
        Thread t1 = new Thread(()->{
            for(int i = 0;i<5;i++){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bu.produce();
            }
        },"T1");

        Thread t2 = new Thread(()->{
            for(int i = 0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                bu.consume();
            }
        },"T2");

        t1.start();
        t2.start();

    }
}
