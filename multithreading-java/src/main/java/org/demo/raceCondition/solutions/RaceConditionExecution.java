package org.demo.raceCondition.solutions;



public class RaceConditionExecution {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runner = ()->{
            for(int i = 1;i<=1000;i++){
                counter.increment();
            }
        };

        Thread t1 = new Thread(runner,"T1");
        Thread t2 = new Thread(runner,"T2");
        Thread t3 = new Thread(runner,"T3");
        Thread t4 = new Thread(runner,"T4");

        try{
            t1.start();
            t2.start();
            t3.start();
            t4.start();

            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Final value of Counter ");
        counter.display();
    }
}
