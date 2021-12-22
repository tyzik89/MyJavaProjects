package com.work.vladimirs.patterns.decorator.beverages;

import com.work.vladimirs.patterns.decorator.Beverage;

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
