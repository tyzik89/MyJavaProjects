package com.work.vladimirs.patterns.decorator.beverages;

import com.work.vladimirs.patterns.decorator.Beverage;

public class Espresso  extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    /**
     * @return "basic" price of Espresso coffee
     */
    @Override
    public double cost() {
        return 1.99;
    }
}
