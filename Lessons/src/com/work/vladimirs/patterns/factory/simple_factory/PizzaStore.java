package com.work.vladimirs.patterns.factory.simple_factory;

import com.work.vladimirs.patterns.factory.simple_factory.pizza_types.Pizza;

public class PizzaStore {

    SimplePizzaFactory simplePizzaFactory;

    PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
