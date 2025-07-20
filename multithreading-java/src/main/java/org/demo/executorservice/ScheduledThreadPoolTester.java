package org.demo.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTester {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for(int i = 0;i<10;i++){
            int finalI = i;
            scheduledExecutorService.scheduleAtFixedRate(() -> {
                System.out.println("From " + Thread.currentThread().getName() + " " + finalI);
            }, 5,5, TimeUnit.SECONDS);

        }
        scheduledExecutorService.awaitTermination(10,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}

