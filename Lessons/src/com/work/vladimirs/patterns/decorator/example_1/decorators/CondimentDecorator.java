package com.work.vladimirs.patterns.decorator.example_1.decorators;

import com.work.vladimirs.patterns.decorator.example_1.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage {

    /**
     * Object Beverage, that will be wrapped in each Decorator.
     * Therefore, every decorator can be wrapper for any beverage.
     */
    Beverage beverage;

    /**
     * All decorators have to return new description
     */
    public abstract String getDescription();
}
