package org.demo.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchUsingThread {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);

        Service webservice = new Service("web-service","web server initialization",latch);
        Service dbservice = new Service("db-service","sql server initialization",latch);
        Service mqservice = new Service("mq-service","messaging queue manager initialization",latch);
        Service notificationservice = new Service("notification-service","centrallised notification server",latch);
        Service logservice = new Service("log-service","server centrallised logging service initialization",latch);

        webservice.start();
        dbservice.start();
        mqservice.start();
        notificationservice.start();
        logservice.start();

        try {
            latch.await();
            System.out.println("server initialization completed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
