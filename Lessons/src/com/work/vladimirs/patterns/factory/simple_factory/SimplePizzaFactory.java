package com.work.vladimirs.patterns.factory.simple_factory;

import com.work.vladimirs.patterns.factory.simple_factory.pizza_types.CheesePizza;
import com.work.vladimirs.patterns.factory.simple_factory.pizza_types.PepperoniPizza;
import com.work.vladimirs.patterns.factory.simple_factory.pizza_types.Pizza;
import com.work.vladimirs.patterns.factory.simple_factory.pizza_types.VegguePizza;

public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggue")) {
            pizza = new VegguePizza();
        }
        return pizza;
    }
}
