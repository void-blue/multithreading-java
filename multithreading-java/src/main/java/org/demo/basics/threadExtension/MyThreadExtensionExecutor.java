package org.demo.basics.threadExtension;

public class MyThreadExtensionExecutor {

    public static void main(String[] args) {
        MyThreadExtension mte1 = new MyThreadExtension("T1");
        MyThreadExtension mte2 = new MyThreadExtension("T2");
        MyThreadExtension mte3 = new MyThreadExtension("T3");

        mte1.start();
        mte2.start();
        mte3.start();


    }
}
