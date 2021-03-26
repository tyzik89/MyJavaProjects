package thread_check_even;

public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    /**
     * Метод синхронизирован
     */
    @Override
    public synchronized int next() {
        ++currentEvenValue;     //опасная точка
        Thread.yield();         //повышение шанса переключение контекста во время нахождения currentEvenValue в не корректном состоянии
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
