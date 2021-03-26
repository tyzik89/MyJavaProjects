import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Создать задачу, которая приостанавливается на случайный промежуток времени от 1 до 10 секунд,
 * затем выводит время ожидания и завершается.
 * Создать и запустить несколько таких задач.
 * (Количество должно задаваться в командной строке)
 */
public class SleepTask implements Runnable {

    private int sleepingTime;

    public SleepTask() {
        Random  random = new Random();
        this.sleepingTime = random.nextInt(10) + 1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.toString());
            return;
        }
    }

    @Override
    public String toString() {
        return "SleepTask: " + Thread.currentThread().toString() + " {" +
                "sleepingTime=" + sleepingTime +
                '}';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество задач: ");
        int num = in.nextInt();
        in.close();

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < num; i++) {
            service.execute(new SleepTask());
        }
        service.shutdown();
    }
}
