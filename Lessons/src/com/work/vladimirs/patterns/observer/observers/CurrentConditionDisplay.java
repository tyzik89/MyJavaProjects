package com.work.vladimirs.patterns.observer.observers;

/**
 * Элемент дисплея, выводящий текущие параметры объекта WeatherData
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    @Override
    public void update(float temp, float humidity, float pressure) {

    }

    @Override
    public void display() {

    }
}
