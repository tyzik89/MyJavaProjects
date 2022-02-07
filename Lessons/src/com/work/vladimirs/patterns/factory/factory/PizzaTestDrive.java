package com.work.vladimirs.patterns.factory.factory;

import com.work.vladimirs.patterns.factory.factory.pizza_types.Pizza;

public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");

        pizza = chicagoStore.orderPizza("cheese");
    }
}
