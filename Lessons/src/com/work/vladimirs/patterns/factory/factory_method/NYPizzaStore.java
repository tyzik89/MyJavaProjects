package com.work.vladimirs.patterns.factory.factory_method;


import com.work.vladimirs.patterns.factory.factory_method.pizza_types.Pizza;
import com.work.vladimirs.patterns.factory.factory_method.pizza_types.new_york_style.NYStyleCheesePizza;
import com.work.vladimirs.patterns.factory.factory_method.pizza_types.new_york_style.NYStyleClamPizza;
import com.work.vladimirs.patterns.factory.factory_method.pizza_types.new_york_style.NYStylePepperoniPizza;
import com.work.vladimirs.patterns.factory.factory_method.pizza_types.new_york_style.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
