package com.work.vladimirs.patterns.observer.observers;

/**
 * Любой другой элемент дисплея
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    @Override
    public void display() {

    }

    @Override
    public void update(float temp, float humidity, float pressure) {

    }
}
