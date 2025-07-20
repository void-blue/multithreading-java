package org.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Service extends Thread{
    private CountDownLatch latch;
    private String task;

    public Service(String name, String task, CountDownLatch latch) {
        super(name);
        this.latch = latch;
        this.task = task;
    }

    @Override
    public void run() {
        try{
            System.out.println("From "+Thread.currentThread().getName()+" starting initialization for "+task);
            for(int i = 0;i<10;i++){
                Thread.sleep(200);
            }

            System.out.println("Task: "+task+" ,completed by "+Thread.currentThread().getName());
            latch.countDown();
        }
        catch(Exception e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
