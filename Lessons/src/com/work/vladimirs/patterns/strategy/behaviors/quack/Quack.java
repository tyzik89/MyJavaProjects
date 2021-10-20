package com.work.vladimirs.patterns.strategy.behaviors.quack;

/**
 * Реализация интерфейса крякания
 * Обычный "кряк"
 */
public class Quack implements QuackBehavior{

    @Override
    public void quck() {
        System.out.println("Quack");
    }
}
