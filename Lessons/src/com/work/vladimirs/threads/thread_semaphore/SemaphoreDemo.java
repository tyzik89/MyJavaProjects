package com.work.vladimirs.threads.thread_semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> fatPool = new Pool<>(Fat.class,  SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckOutFatTask<Fat>(fatPool));
        }
        System.out.println("All CheckOutFatTask created ");
        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = fatPool.checkOut();
            System.out.println(i + ": main thread checked out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    //Семофор предотвращает дополнителную выдачу,
                    //поэтому вызов блокируется
                    fatPool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println("CheckOut interrupted");
                }
            }
        });

        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);   //Отмена заблокированных вызовов
        System.out.println("Checking in objects in " + list);
        for (Fat fat : list) {
            fatPool.checkIn(fat);
        }
        exec.shutdown();
    }
}
