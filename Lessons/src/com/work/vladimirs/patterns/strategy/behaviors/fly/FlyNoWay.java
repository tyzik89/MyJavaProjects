package com.work.vladimirs.patterns.strategy.behaviors.fly;

/**
 * Реализация интерфейса полёта
 * Своеобразная заглушка поведения полёта, т.е. полёт отсутсвует
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Fly no way");
    }
}
