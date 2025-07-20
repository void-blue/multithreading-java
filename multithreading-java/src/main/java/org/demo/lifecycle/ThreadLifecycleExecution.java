package org.demo.lifecycle;

public class ThreadLifecycleExecution {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            System.out.println("Custom-Thread state after start RUNNING");
            for(int  i = 1;i<=5;i++){
                try{
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

        },"Custom-Thread");

        System.out.println("Custom-Thread state after declaraion "+t.getState());

        t.start();
        System.out.println("Custom-Thread state after start method called "+t.getState());
        Thread.sleep(200);
        System.out.println("Custom-Thread state currently "+t.getState());
        t.join();
        System.out.println("Custom-Thread state after Thread completion "+t.getState());


    }
}
