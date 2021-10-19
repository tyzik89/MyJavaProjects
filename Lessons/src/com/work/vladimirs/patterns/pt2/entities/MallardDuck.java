package com.work.vladimirs.patterns.pt2.entities;

import com.work.vladimirs.patterns.pt2.behaviors.fly.FlyBehavior;
import com.work.vladimirs.patterns.pt2.behaviors.fly.FlyWithWings;
import com.work.vladimirs.patterns.pt2.behaviors.quack.Quack;
import com.work.vladimirs.patterns.pt2.behaviors.quack.QuackBehavior;

/**
 * Дикая утка.
 * Имеет возможность летать и крякать
 */
public class MallardDuck extends Duck{

    public MallardDuck() {
        super(new Quack(), new FlyWithWings());
    }

    public MallardDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I’m a real Mallard duck");
    }
}
