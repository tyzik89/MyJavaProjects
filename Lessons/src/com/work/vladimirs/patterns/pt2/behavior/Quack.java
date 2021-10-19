package com.work.vladimirs.patterns.pt2.behavior;

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
