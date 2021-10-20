package com.work.vladimirs.patterns.strategy;

import com.work.vladimirs.patterns.strategy.behaviors.fly.FlyRocketBehavior;
import com.work.vladimirs.patterns.strategy.entities.Duck;
import com.work.vladimirs.patterns.strategy.entities.MallardDuck;
import com.work.vladimirs.patterns.strategy.entities.ModelDuck;

class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();

        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketBehavior());  // Добавление ракетных двигателей на утку-приманку =)
        model.performFly();
    }
}
