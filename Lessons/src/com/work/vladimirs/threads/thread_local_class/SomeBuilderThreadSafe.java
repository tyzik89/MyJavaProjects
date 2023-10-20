package com.work.vladimirs.threads.thread_local_class;

public class SomeBuilderThreadSafe implements SomeBuilder{

    private ThreadLocal<Integer> counter = new ThreadLocal<Integer>();

    public void build() {
        System.out.println("Thread " + Thread.currentThread().getName() + " do some thread safe actions");
        // ThreadLocal-переменные изолированы в потоках, то инициализация такой переменной должна происходить в том же потоке,
        // в котором она будет использоваться
        // Инициализацию можно выполнить через метод initialValue()
        if (counter.get() == null)
            counter.set(0);

        counter.set(counter.get() + 1);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCounter() {
        return counter.get();
    }
}
