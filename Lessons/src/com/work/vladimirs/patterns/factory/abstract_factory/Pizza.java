package com.work.vladimirs.patterns.factory.abstract_factory;

import com.work.vladimirs.patterns.factory.abstract_factory.ingredients_factories.ingredients.*;

import java.util.Arrays;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Vegetable veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    /**
     * Метод prepare стал абстрактным.
     * В нем мы будем собирать ингредиен-
     * ты, необходимые для приготовления
     * пиццы. Которые, разумеется, будут
     * производиться фабрикой ингредиентов
     */
    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                '}';
    }
}
