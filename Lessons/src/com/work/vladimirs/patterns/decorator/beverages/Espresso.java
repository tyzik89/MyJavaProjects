package com.work.vladimirs.patterns.decorator.beverages;

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
