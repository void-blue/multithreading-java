package org.demo.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class cyclicBarrierWithThread {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5,()->{
            System.out.println("Inside the finalizing thread ");
            try{
                Thread.sleep(100);
            }catch(Exception e ){
                e.printStackTrace();
            }
            System.out.println("all threads executed, system setup completed");
        });

        Thread webService = new Thread(new ThreadIMPL(barrier,"web service setup"),"Web service");
        Thread dbService = new Thread(new ThreadIMPL(barrier,"db server setup "),"DB service");
        Thread notificationService = new Thread(new ThreadIMPL(barrier,"centrallized notification server setup"),"notification service");
        Thread logService = new Thread(new ThreadIMPL(barrier,"central logging service setup"),"log service");
        Thread cloudService = new Thread(new ThreadIMPL(barrier,"cloud platform setup"),"cloud service");


        webService.start();
        dbService.start();
        notificationService.start();
        logService.start();
        cloudService.start();

        System.out.println("Barrier in broken state "+barrier.isBroken());
        System.out.println("threads in trip "+barrier.getParties());



    }

}

class ThreadIMPL implements Runnable{

    private CyclicBarrier barrier;
    private String task;

    public ThreadIMPL(CyclicBarrier barrier, String task) {
        this.barrier = barrier;
        this.task = task;
    }

    @Override
    public void run() {
        try{
            System.out.println("Thread "+Thread.currentThread().getName()+" performing setup of :"+task);
            for(int i = 0;i<50;i++){
                Thread.sleep(100);
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" completed setup of : "+task+"\t\twaiting for other threads to finalize");
            barrier.await();
        }catch(Exception e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
