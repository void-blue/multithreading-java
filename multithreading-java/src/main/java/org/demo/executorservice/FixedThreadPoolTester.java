package org.demo.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTester {

    public static void main(String[] args) {
        int number = 3;

        ExecutorService executorService = Executors.newFixedThreadPool(number);
        for(int  i = 0;i<100;i++){
            int k = i;

            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+" value "+k);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

        }

        executorService.shutdown();
    }
}
