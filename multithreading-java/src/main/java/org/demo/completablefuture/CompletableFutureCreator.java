package org.demo.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCreator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cfs = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("from completable future thread "+Thread.currentThread().getName());
                for (int i = 0;i<10;i++){

                        Thread.sleep(100);


                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                return "OK";
            }
        });

        System.out.println("From "+cfs+" value "+cfs.get());
    }
}
