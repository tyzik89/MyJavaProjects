package com.work.vladimirs.patterns.pt2.entities;

import com.work.vladimirs.patterns.pt2.behaviors.fly.FlyNoWay;
import com.work.vladimirs.patterns.pt2.behaviors.quack.Quack;

/**
 * Утка-приманка.
 * Не умеет летать, симулирует крякание
 */
public class ModelDuck extends Duck{

    public ModelDuck() {
        super(new Quack(), new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("It's model duck");
    }
}
