package com.work.vladimirs.patterns.template_method.with_interceptor;

/**
 * Перехватчик в паттерне шаблонный метод
 */
abstract class CaffeineBeverageWithHook {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * Метод-перехватчик.
     * Method interceptor   
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
