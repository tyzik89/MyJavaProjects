package com.work.vladimirs.patterns.pt2.behavior;

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
