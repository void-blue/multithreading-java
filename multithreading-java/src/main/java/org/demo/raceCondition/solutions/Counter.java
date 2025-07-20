package org.demo.raceCondition.solutions;

public class Counter {

    private int val;

    public Counter() {
        val = 0;
    }

    public synchronized void increment(){
        this.val++;
    }

    public void display(){
        System.out.println("value = "+this.val);
    }
}
