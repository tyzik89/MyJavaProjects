package com.work.vladimirs.patterns.pt2.entities;

import com.work.vladimirs.patterns.pt2.behaviors.fly.FlyBehavior;
import com.work.vladimirs.patterns.pt2.behaviors.quack.QuackBehavior;

/**
 * Абстрактный класс утки
 */
public abstract class Duck {


    /**
     * Делегирование поведения крякания
     */
    private QuackBehavior quackBehavior;

    /**
     * Делегирование поведения полёта
     */
    private FlyBehavior flyBehavior;

    public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        this.quackBehavior = quackBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quck();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public abstract void display();

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
