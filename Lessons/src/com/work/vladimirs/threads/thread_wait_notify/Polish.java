package com.work.vladimirs.threads.thread_wait_notify;

import java.util.concurrent.TimeUnit;

class Polish implements Runnable {
    private Car car;

    public Polish(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Polish!");
                TimeUnit.SECONDS.sleep(1);
                car.polish();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting from Polish task via interrupt");
        }
        System.out.println("Ending polish task");
    }
}
