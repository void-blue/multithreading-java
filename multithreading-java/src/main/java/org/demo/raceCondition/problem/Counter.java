package org.demo.raceCondition.problem;

public class Counter {

    private int val;

    public Counter() {
        val = 0;
    }

    public void increment(){
        this.val++;
    }

    public void display(){
        System.out.println("value = "+this.val);
    }
}
