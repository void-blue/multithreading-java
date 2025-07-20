package org.demo.executorservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CachedThreadPoolTester {

    public static void main(String[] args) {
        Callable<Integer> c1 = ()->{
            int sum2 = 0;
            for(int i = 1;i<=100/2;i++){
                sum2 = sum2+2*i;
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+" sum2 value "+sum2);
            return sum2;
        };

        Callable<Integer> c2 = ()->{
            int sum3 = 0;
            for(int i = 1;i<=100/3;i++){
                sum3 = sum3+3*i;
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+" sum3 value "+sum3);
            return sum3;
        };

        Callable<Integer> c3 = ()->{
            int sum5 = 0;
            for(int i = 1;i<=100/5;i++){
                sum5 = sum5+5*i;
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+" sum5 value "+sum5);
            return sum5;
        };

        Callable<Integer> c4 = ()->{
            int sum7 = 0;
            for(int i = 1;i<=100/7;i++){
                sum7 = sum7+2*i;
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+" sum7 value "+sum7);
            return sum7;
        };

        List<Callable<Integer>> list = Arrays.asList(c1,c2,c3,c4);

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            List<Future<Integer>> futures = executorService.invokeAll(list);
            int sum = 0;
            for(Future<Integer> future: futures){
                sum = sum+future.get();
            }
            System.out.println("overall sum "+sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
