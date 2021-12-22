package com.work.vladimirs.patterns.decorator.beverages;

import com.work.vladimirs.patterns.decorator.Beverage;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
