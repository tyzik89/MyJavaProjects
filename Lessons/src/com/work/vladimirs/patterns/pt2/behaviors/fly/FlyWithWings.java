package com.work.vladimirs.patterns.pt2.behaviors.fly;

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
