package com.work.vladimirs.patterns.decorator.beverages;

public abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
