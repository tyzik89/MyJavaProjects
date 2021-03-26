package thread_blocking_queue;

public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                //Проверить, что все тосты идут по порядку и намазаны джемом
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Eater " + Thread.currentThread().getId() + " interrupted: " + ex);
        }
        System.out.println("Eater off");
    }
}
