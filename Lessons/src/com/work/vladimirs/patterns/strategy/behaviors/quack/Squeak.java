package com.work.vladimirs.patterns.strategy.behaviors.quack;

/**
 * Реализация интерфейса крякания
 * Симуляция "кряка"
 */
public class Squeak implements QuackBehavior{

    @Override
    public void quck() {
        System.out.println("Squeak");
    }
}
