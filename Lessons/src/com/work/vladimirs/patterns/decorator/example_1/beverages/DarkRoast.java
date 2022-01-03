package com.work.vladimirs.patterns.decorator.example_1.beverages;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
