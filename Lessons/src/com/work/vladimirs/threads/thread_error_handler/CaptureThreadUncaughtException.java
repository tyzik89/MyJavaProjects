package com.work.vladimirs.threads.thread_error_handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureThreadUncaughtException {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new CustomThreadFactory());
        executorService.execute(new TaskThrowException());
        executorService.shutdown();
    }
}
