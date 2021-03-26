package thread_error_handler;

import java.util.concurrent.ThreadFactory;

/**
 * Кастомная фабрика потоков,
 * создаёт новый поток и устанавливает ему новый обработчик исключений
 */
public class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("Process of creating new thread by custom factory - " + this);
        Thread thread = new Thread(r);
        System.out.println("New thread - " + thread + " is created by custom factory");
        thread.setUncaughtExceptionHandler(new CustomThreadExceptionHandler());
        System.out.println("Set custom exception handler - " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}
