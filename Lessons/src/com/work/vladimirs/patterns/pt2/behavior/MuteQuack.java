package com.work.vladimirs.patterns.pt2.behavior;

public class MuteQuack implements QuackBehavior{

    @Override
    public void quck() {
        System.out.println("<< Silence >>");
    }
}
