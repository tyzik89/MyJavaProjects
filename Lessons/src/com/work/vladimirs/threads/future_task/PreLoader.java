package com.work.vladimirs.threads.future_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PreLoader {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PreLoader preLoader = new PreLoader();
        preLoader.start();
        System.out.println("Preloader started. " + Thread.currentThread().getName());
        // Waiting till heavy obj will be loaded
        System.out.println(preLoader.get());
    }

    private final FutureTask<ProductInfo> future =
            new FutureTask<>(new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws Exception {
                    System.out.println("Start loading heavy data in " + Thread.currentThread().getName());
                    return loadProductInfo();
                }
            });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws ExecutionException, InterruptedException {
        return future.get();
    }

    /**
     * External method for load something heavy
     */
    private ProductInfo loadProductInfo() {
        try {
            System.out.println(Thread.currentThread().getName() + " sleep for 10000ms");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ProductInfo("Load from DB");
    }

    static class ProductInfo {
        private final String info;

        public ProductInfo(String info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "ProductInfo{" +
                    "info='" + info + '\'' +
                    '}';
        }
    }
}
