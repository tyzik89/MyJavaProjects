package com.work.vladimirs.threads.thread_local_class;

public class SomeBuilderNotThreadSafe implements SomeBuilder {

    private int counter;

    public void build() {
        System.out.println("Thread " + Thread.currentThread().getName() + " do some NOT thread safe actions");
        counter++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCounter() {
        return counter;
    }
}
