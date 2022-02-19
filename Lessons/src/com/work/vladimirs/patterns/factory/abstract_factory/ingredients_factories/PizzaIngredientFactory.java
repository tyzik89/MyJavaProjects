package com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories;

import com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories.ingredients.*;

/**
 * Абстрактная фабрика ингредиентов
 */
public interface PizzaIngredientFactory {

    // Методы абстрактной фабрики часто реализуются как фабричные методы

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Vegetable[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}
