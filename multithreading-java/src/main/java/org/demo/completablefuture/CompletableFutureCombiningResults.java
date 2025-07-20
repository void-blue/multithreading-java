package org.demo.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//sum pf all numbers between 1 and 100 = sum of all even numbers+sum of all odd numbers
public class CompletableFutureCombiningResults {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> evenSum = CompletableFuture.supplyAsync(()->{
            int sum = 0;
            try{
                System.out.println("From "+Thread.currentThread().getName()+" getting even sum ");
                for(int i = 1;i<=100;i++){
                    Thread.sleep(10);
                    if(i%2==0)
                        sum = sum+i;
                }
            }catch(Exception e){
                Thread.currentThread().interrupt();
            }finally{
                return sum;
            }
        });

        CompletableFuture<Integer> oddSum = CompletableFuture.supplyAsync(()->{
            int sum = 0;
            try{
                System.out.println("From "+Thread.currentThread().getName()+" getting odd sum ");
                for(int i = 1;i<=100;i++){
                    Thread.sleep(10);
                    if(i%2!=0)
                        sum = sum+i;
                }
            }catch(Exception e){
                Thread.currentThread().interrupt();
            }finally{
                return sum;
            }
        });
        //then apply to get string with result
        CompletableFuture<String> evenSumString = evenSum.thenApply(x -> "Sum of even numbers is " + x);
        CompletableFuture<String> oddSumString = oddSum.thenApply(x -> "Sum of odd numbers is " + x);

        //then combine to get result post combining future values of both Completable Futures
        CompletableFuture<Integer> finalSum = evenSum.thenCombine(oddSum,(e1,e2)->e1+e2);
        System.out.println(evenSumString.get());
        System.out.println(oddSumString.get());
        System.out.println("Final sum is "+finalSum.get());

        //CompletableFuture to test exception handling

        CompletableFuture<Integer> exceptionalItem = CompletableFuture.supplyAsync(()->{
            System.out.println("Will try to throw exception to check exceptionally block and get default value ");

            return 1/0;

        }).exceptionally(e->{
            System.out.println("exception blck executing delivering default value ");
            return -1;
        });

        System.out.println("value of exceptional item "+exceptionalItem.get());

    }
}
