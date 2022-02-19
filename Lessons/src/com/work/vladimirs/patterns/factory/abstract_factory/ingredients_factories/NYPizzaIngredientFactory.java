package com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories;

import com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories.ingredients.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override

    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Vegetable[] createVeggies() {
        Vegetable veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
