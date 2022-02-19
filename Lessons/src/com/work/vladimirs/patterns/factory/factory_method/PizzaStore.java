package com.work.vladimirs.patterns.factory.factory_method;


import com.work.vladimirs.patterns.factory.factory_method.pizza_types.Pizza;

public abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    final Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
