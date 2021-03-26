package thread_blocking_queue;

import java.util.concurrent.TimeUnit;

public class Butterer implements Runnable {
    private ToastQueue dryQueue;
    private ToastQueue butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Блокирует до готовности следующего тоста
                Toast t = dryQueue.take();
                TimeUnit.SECONDS.sleep(1);
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException ex) {
            System.out.println("Butterer " + Thread.currentThread().getId() + " interrupted: " + ex);
        }
        System.out.println("Butterer off");
    }
}
