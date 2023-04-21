package com.work.vladimirs.annotations.social_network_bot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Указывает, что аннотация может быть использована во время выполнения через Reflection
@Target(ElementType.METHOD) // Цель аннотации - метод
public @interface Command {
    // Команда за которую будет отвечать функция (например "привет");
    String name();
    // Аргументы команды, будет использоваться для вывода Help списка команд
    String args();
    // Описание команд, будет использоваться для вывода Help списка команд
    String desc();
    // Минимальное количество аргументов
    int minArgs() default 0;
    // Максимальное количество аргументов.
    int maxArgs() default Integer.MAX_VALUE;
    // Показывать ли команду в Help списке
    boolean showInHelp() default true;
    // Какие команды будут считаться эквивалентными нашей
    // (Например для "привет", это может быть "Здаров", "Прив" и т.д.)
    String[] aliases();
}
