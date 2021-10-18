package com.work.vladimirs.patterns.pt2.behavior;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Fly no way");
    }
}
