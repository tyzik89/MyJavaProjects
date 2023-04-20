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
    // Аргументы команды, будет использоваться для вывода списка команд
    String args();

}
