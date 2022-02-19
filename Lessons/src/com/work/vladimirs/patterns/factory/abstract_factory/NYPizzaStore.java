package com.work.vladimirs.patterns.factory.abstract_factory;

import com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories.NYPizzaIngredientFactory;
import com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {

    protected Pizza createPizza(String item) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory =
                new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheeese Pizza");
        } else if (item.equals("veggie")) {
//            pizza = new Veggie(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if (item.equals("pepperoni")) {
//            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
