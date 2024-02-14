package com.work.vladimirs.threads.thread_local_class;

import java.util.Hashtable;

public class SomeBuilderBadDecisionThreadSafe implements SomeBuilder {

    private Hashtable<String, Integer> counters = new Hashtable<String, Integer>();

    @Override
    public void build() {
        System.out.println("Thread " + Thread.currentThread().getName() + " do some bad decision and thread safe actions");
        if (!counters.containsKey(Thread.currentThread().getName()))
            counters.put(Thread.currentThread().getName(), 0);

        counters.put(Thread.currentThread().getName(), counters.get(Thread.currentThread().getName()) + 1);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCounter() {
        return counters.get(Thread.currentThread().getName());
    }
}
