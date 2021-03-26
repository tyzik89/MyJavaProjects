package thread_error_handler;

/**
 * Кастомный обработчик ошибок
 * В данно случае просто печатает причину исключения
 */
public class CustomThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("cause - " + e);
    }
}
