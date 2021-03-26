package thread_error_handler;

/**
 * Задача, печатающая информацию о потоке в которм выполняется
 * и выбрасывающая исключение
 */
public class TaskThrowException implements Runnable {

    @Override
    public void run() {
        Thread currThreadInfo = Thread.currentThread();
        System.out.println("This task run by - " + currThreadInfo);
        System.out.println("error - " + currThreadInfo.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
