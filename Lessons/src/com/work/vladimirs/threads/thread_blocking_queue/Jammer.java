package thread_blocking_queue;

import java.util.concurrent.TimeUnit;

public class Jammer implements Runnable {
    private ToastQueue butteredQueue;
    private ToastQueue finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = butteredQueue.take();
                TimeUnit.SECONDS.sleep(1);
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException ex) {
            System.out.println("Jammer " + Thread.currentThread().getId() + " interrupted: " + ex);
        }
        System.out.println("Jammer off");
    }
}
