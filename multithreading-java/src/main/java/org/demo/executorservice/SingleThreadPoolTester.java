package org.demo.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadPoolTester {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("from " + Thread.currentThread().getName() + " i " + i);


            }
        }, -1);

        System.out.println("returned value "+submit.get());
        executorService.shutdown();
    }
}
