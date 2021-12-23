package com.work.vladimirs.patterns.decorator.beverages;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
