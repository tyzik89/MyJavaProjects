package com.work.vladimirs.patterns.pt2;

import com.work.vladimirs.patterns.pt2.behaviors.fly.FlyRocketBehavior;
import com.work.vladimirs.patterns.pt2.entities.Duck;
import com.work.vladimirs.patterns.pt2.entities.MallardDuck;
import com.work.vladimirs.patterns.pt2.entities.ModelDuck;

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
