package org.demo.basics.runnableImplementation;

public class MyRunnableImplementationExecutor {

    public static void main(String[] args) {

        MyRunnableImplementation mri1 = new MyRunnableImplementation();
        MyRunnableImplementation mri2 = new MyRunnableImplementation();
        MyRunnableImplementation mri3 = new MyRunnableImplementation();

        Thread t1 = new Thread(mri1,"T1");
        Thread t2 = new Thread(mri2,"T2");
        Thread t3 = new Thread(mri3,"T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished execution of threads");

    }
}
