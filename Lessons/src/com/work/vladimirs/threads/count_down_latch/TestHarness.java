package com.work.vladimirs.threads.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class TestHarness {

    public static void main(String[] args) throws InterruptedException {
        TestHarness testHarness = new TestHarness();
        long time = testHarness.timeTasks(5, new Runnable() {
            @Override
            public void run() {
                try {
                    long timeSleep = ThreadLocalRandom.current().nextLong(10000)+1;
                    Thread.sleep(timeSleep);
                    System.out.println(Thread.currentThread().getName() + ", sleep: " + timeSleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("time: " + time);
    }

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGAte = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGAte.countDown();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGAte.await();
        long end = System.nanoTime();
        return end - start;
    }
}
