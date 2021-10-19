package com.work.vladimirs.patterns.pt2;

import com.work.vladimirs.patterns.pt2.entities.Duck;
import com.work.vladimirs.patterns.pt2.entities.MallardDuck;

class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();

        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.swim();
    }
}
