package thread_check_even;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    /**
     * Метод использует мьютекс с именем lock для защиты критического блока
     */
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;     //опасная точка
            Thread.yield();         //повышение шанса переключение контекста во время нахождения currentEvenValue в не корректном состоянии
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
