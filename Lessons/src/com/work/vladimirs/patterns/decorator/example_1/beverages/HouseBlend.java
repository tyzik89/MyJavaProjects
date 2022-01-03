package com.work.vladimirs.patterns.decorator.example_1.beverages;

public class HouseBlend  extends Beverage {

    public HouseBlend() {
        description = "House Blend coffee";
    }

    /**
     * @return "basic" price of HouseBlend coffee
     */
    @Override
    public double cost() {
        return .89;
    }
}
