package thread_blocking_queue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(1 + rand.nextInt(3));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        } catch (InterruptedException ex) {
            System.out.println("Toaster " + Thread.currentThread().getId() + " interrupted: " + ex);
        }
        System.out.println("Toaster off");
    }
}
