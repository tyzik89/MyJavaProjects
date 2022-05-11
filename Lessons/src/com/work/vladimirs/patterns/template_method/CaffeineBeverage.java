package com.work.vladimirs.patterns.template_method;

abstract class CaffeineBeverage {

    /**
     * Для приготовления чая и кофе будет использоваться один метод — prepareRecipe().
     * Это и есть ШАБЛОННЫЙ МЕТОД.
     * Метод служит шаблоном для алгоритма, в данном случае шаблоном приготовления напитка.
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    void boilWater() {
        System.out.println("Boiling water");
    }
}
