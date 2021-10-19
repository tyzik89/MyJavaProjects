package com.work.vladimirs.patterns.pt2.entities;

import com.work.vladimirs.patterns.pt2.behavior.FlyNoWay;
import com.work.vladimirs.patterns.pt2.behavior.Quack;

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
