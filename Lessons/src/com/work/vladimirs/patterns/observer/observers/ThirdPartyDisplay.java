package com.work.vladimirs.patterns.observer.observers;

/**
 * Любой другой элемент дисплея
 */
public class ThirdPartyDisplay implements Observer, DisplayElement {

    @Override
    public void display() {
        // some code
    }

    @Override
    public void update() {
        // some code
    }
}
