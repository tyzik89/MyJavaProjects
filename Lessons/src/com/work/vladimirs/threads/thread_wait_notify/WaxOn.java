package thread_wait_notify;

import java.util.concurrent.TimeUnit;

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("WaxOn!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForPolish();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting from WaxOn task via interrupt");
        }
        System.out.println("Ending WaxOn task");
    }
}
