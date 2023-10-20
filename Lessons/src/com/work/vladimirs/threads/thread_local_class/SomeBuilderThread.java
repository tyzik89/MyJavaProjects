package com.work.vladimirs.threads.thread_local_class;

public class SomeBuilderThread extends Thread {

    private SomeBuilder someBuilder;

    public SomeBuilderThread(SomeBuilder someBuilder) {
        this.someBuilder = someBuilder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            someBuilder.build();
        }
        System.out.println("My name is " + Thread.currentThread().getName() + " and I do " + someBuilder.getCounter() + " actions");
    }

    public static void main(String[] args) {
        SomeBuilder builder = new SomeBuilderNotThreadSafe();
        Thread thread1 = new SomeBuilderThread(builder);
        Thread thread2 = new SomeBuilderThread(builder);
        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // =======================================================================

        builder = new SomeBuilderBadDecisionThreadSafe();
        Thread thread3 = new SomeBuilderThread(builder);
        Thread thread4 = new SomeBuilderThread(builder);
        try {
            thread3.start();
            thread4.start();

            thread3.join();
            thread4.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // =======================================================================

        builder = new SomeBuilderThreadSafe();
        Thread thread5 = new SomeBuilderThread(builder);
        Thread thread6 = new SomeBuilderThread(builder);
        try {
            thread5.start();
            thread6.start();

            thread5.join();
            thread6.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
