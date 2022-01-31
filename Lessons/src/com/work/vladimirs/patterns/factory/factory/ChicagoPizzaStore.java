package com.work.vladimirs.patterns.factory.factory;

import com.work.vladimirs.patterns.factory.factory.pizza_types.Pizza;
import com.work.vladimirs.patterns.factory.factory.pizza_types.chicago_style.ChicagoStyleCheesePizza;
import com.work.vladimirs.patterns.factory.factory.pizza_types.chicago_style.ChicagoStyleClamPizza;
import com.work.vladimirs.patterns.factory.factory.pizza_types.chicago_style.ChicagoStylePepperoniPizza;
import com.work.vladimirs.patterns.factory.factory.pizza_types.chicago_style.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
