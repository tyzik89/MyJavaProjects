package com.work.vladimirs.annotations.social_network_bot;

import java.lang.reflect.Method;

public class CommandListener {

    @Command(name = "привет",
            args = "",
            desc = "Приветствие",
            aliases = {"дратути", "хай", "добрый день"})
    public void hello(String[] args) {
        System.out.println("Супер AI приветствует тебя!");
    }

    @Command(name = "пока",
            args = "",
            desc = "",
            showInHelp = false,
            aliases = {"удачи", "до свидания"})
    public void bye(String[] args) {
        System.out.println("Удачи и исполнения всех желаний!");
    }

    @Command(name = "помощь",
            args = "",
            desc = "Выводит список команд",
            aliases = {"help", "команды"})
    public void help(String[] args) {
        StringBuilder sb = new StringBuilder("Список команд: \n");
        for (Method m : this.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Command.class)) {
                Command com = m.getAnnotation(Command.class);
                if (com.showInHelp()) {
                    sb.append("Бот, ")
                            .append(com.name()).append(" ")
                            .append(com.args()).append(" - ")
                            .append(com.desc()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
