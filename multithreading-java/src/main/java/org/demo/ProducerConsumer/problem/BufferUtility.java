package org.demo.ProducerConsumer.problem;

import java.util.Random;

public class BufferUtility {

    private int count;
    private int size;
    private int arr[];

    public BufferUtility() {
        size = 2;
        count = 0;
        arr =new int[2];
    }

    public synchronized void produce(){
        while(count==size){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arr[count] = new Random().nextInt(100);

        System.out.println("Item produced "+ arr[count]);
        count =count++;
        notifyAll();
    }

    public synchronized void consume(){
        while(count==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        int item = arr[count-1];
        count--;
        System.out.println("Consumed item "+ item);
        notifyAll();
    }
}
