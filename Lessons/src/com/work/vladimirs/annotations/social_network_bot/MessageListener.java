package com.work.vladimirs.annotations.social_network_bot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageListener {

    // Команда : метод, для её обработки
    private static final Map<String, Method> COMMANDS = new HashMap<>();

    // Объект класса с командами (по сути нужен нам для рефлексии)
    private static final CommandListener LISTENER = new CommandListener();

    static {
        // Берем список всех методов в классе CommandListener
        for (Method m : LISTENER.getClass().getDeclaredMethods()) {
            // Смотрим, есть ли у метода нужная нам Аннотация @Command
            if (m.isAnnotationPresent(Command.class)) {
                // Берем объект нашей Аннотации
                Command cmd = m.getAnnotation(Command.class);
                // Помещаем в мапу в качестве ключа нашей карты параметр name(),
                // определенный у нашей аннотации,
                // m — переменная, хранящая наш метод
                COMMANDS.put(cmd.name(), m);

                // Также заносим каждый элемент aliases
                // Как ключ указывающий на тот же самый метод.
                for (String s : cmd.aliases()) {
                    COMMANDS.put(s, m);
                }
            }
        }
    }

    public void onMessageReceived(String event) {
        //Убираем чувствительность к регистру (БоТ, бОт и т.д.)
        String message = event.toLowerCase();
        if (message.startsWith("бот")) {
            try {
                // получим массив {"Бот", "(команду)", "аргумент1", "аргумент2",... "аргументN"};
                String[] args = message.split(" ");
                // Для удобства уберем "бот" и отделим команду от аргументов
                String command = args[1];
                // Получили command = "(команда)"; nArgs = {"аргумент1", "аргумент2",..."аргументN"};
                // Данный массив может быть пустым
                String[] nArgs = Arrays.copyOfRange(args, 2, args.length);

                Method m = COMMANDS.get(command);
                if (m == null) {
                    // вывод помощи
                    LISTENER.help(null);
                    return;
                }
                Command com = m.getAnnotation(Command.class);
                if (nArgs.length < com.minArgs()) {
                    System.out.println("Not enough arguments for command: " + com.name());
                    LISTENER.help(null);
                    return;
                } else if (nArgs.length > com.maxArgs()) {
                    System.out.println("Excess amount of arguments for command: " + com.name());
                    LISTENER.help(null);
                    return;
                }
                // Через рефлексию вызываем нашу функцию-обработчик
                // Именно потому что мы всегда передаем nArgs у функции должен быть параметр
                // String[] args — иначе она просто не будет найдена;
                m.invoke(LISTENER, new Object[] {nArgs});
            } catch (ArrayIndexOutOfBoundsException e) {
                // Вывод списка команд или какого-либо сообщения
                // В случае если просто написать "Бот"
                LISTENER.help(null);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
