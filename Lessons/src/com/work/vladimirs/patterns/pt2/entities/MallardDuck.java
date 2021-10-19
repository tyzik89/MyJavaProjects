package com.work.vladimirs.patterns.pt2.entities;

import com.work.vladimirs.patterns.pt2.behavior.FlyBehavior;
import com.work.vladimirs.patterns.pt2.behavior.FlyWithWings;
import com.work.vladimirs.patterns.pt2.behavior.Quack;
import com.work.vladimirs.patterns.pt2.behavior.QuackBehavior;

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
