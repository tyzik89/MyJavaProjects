package com.work.vladimirs.patterns.pt2.behaviors.fly;

/**
 * Реализация интерфейса полёта
 * Реализация поведения полёта ракеты
 */
public class FlyRocketBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
