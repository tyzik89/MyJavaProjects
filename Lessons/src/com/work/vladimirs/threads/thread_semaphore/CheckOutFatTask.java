package com.work.vladimirs.threads.thread_semaphore;

import java.util.concurrent.TimeUnit;

class CheckOutFatTask<T> implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckOutFatTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " check out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " check in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread() + " is interrupted");
        }
    }

    public String toString()  {
        return "CheckOutFatTask" + id + " ";
    }


}
