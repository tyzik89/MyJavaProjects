package thread_wait_notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WaxOMatic {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Polish(car));
        exec.execute(new WaxOn(car));

        TimeUnit.SECONDS.sleep(10);   //Конвеер работает какое-то время
        exec.shutdownNow();                   //Остановка всех задач конвеера
    }
}
