package com.work.vladimirs.patterns.pt2.behavior;

/**
 * Реализация интерфейса полёта
 * Вариант полёта при помощи крыльев
 */
public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
