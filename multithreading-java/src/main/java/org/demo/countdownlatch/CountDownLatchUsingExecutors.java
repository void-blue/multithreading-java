package org.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchUsingExecutors {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        RunnableServices webservice = new RunnableServices("web-server initialization",latch);
        RunnableServices notificationservice = new RunnableServices("notification-server initialization",latch);
        RunnableServices dbservice = new RunnableServices("db-server initialization",latch);
        RunnableServices logservice = new RunnableServices("log-server initialization",latch);
        RunnableServices mqservice = new RunnableServices("mq-server initialization",latch);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(webservice);
        executorService.execute(notificationservice);
        executorService.execute(dbservice);
        executorService.execute(logservice);
        executorService.execute(mqservice);
        try{
            latch.await();
            System.out.println("all services initialized ");

        }catch (Exception e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        finally{
            executorService.shutdown();
        }


    }
}

class RunnableServices implements Runnable{

    private String task;
    private CountDownLatch latch;

    public RunnableServices(String task, CountDownLatch latch) {
        this.task = task;
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            System.out.println("From "+Thread.currentThread().getName()+" starting initialization for "+task);
            for(int i = 0;i<10;i++){
                Thread.sleep(200);
            }

            System.out.println("Task: "+task+" ,completed by "+Thread.currentThread().getName());
            latch.countDown();
        }
        catch(Exception e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
