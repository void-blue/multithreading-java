package org.demo.basics.threadLambda;

public class ThreadLambdaExecution {

    public static void main(String[] args) {
        // Anonymous class implementation of Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=10;i++){
                    System.out.println("From "+Thread.currentThread().getName()+" i "+i);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        };
        //Java Lambda expression to implement Runnable interface
        Runnable r2 = ()->{
            for(int j = 1;j<=10;j++){
                System.out.println("from "+Thread.currentThread().getName()+" j "+j);
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r1,"T1");
        Thread t2 = new Thread(r2,"T2");
        Thread t3 = new Thread(()->{
            for(int k = 1;k<=10;k++){
                System.out.println("from "+Thread.currentThread().getName()+" k "+k);
                try{
                    Thread.sleep(100);
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
