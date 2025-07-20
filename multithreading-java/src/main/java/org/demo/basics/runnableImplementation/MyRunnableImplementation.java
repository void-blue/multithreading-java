package org.demo.basics.runnableImplementation;

public class MyRunnableImplementation implements Runnable{


    @Override
    public void run() {
        for(int i = 1;i<=10;i++){
            System.out.println("From "+Thread.currentThread().getName()+" i "+i);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
