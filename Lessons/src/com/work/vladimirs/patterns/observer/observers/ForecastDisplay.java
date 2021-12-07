package com.work.vladimirs.patterns.observer.observers;

import com.work.vladimirs.patterns.observer.subject.WeatherData;

/**
 * Элемент дисплея, выводящий прогноз погоды по показаниям барометра
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private float currentPressure;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // some code
    }

    @Override
    public void update() {
        // some code
    }
}
