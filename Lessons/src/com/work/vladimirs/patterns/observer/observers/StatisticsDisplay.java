package com.work.vladimirs.patterns.observer.observers;

import com.work.vladimirs.patterns.observer.subject.WeatherData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Элемент дисплея, выводящий минимальное, среднее, максимальное значения температуры
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private List<Float> listOfTemperature;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        listOfTemperature = new ArrayList<>(5);
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        OptionalDouble avg = listOfTemperature.stream().mapToDouble(a -> a).average();
        System.out.println("Avg/Max/Min temperature =: "
                + "/" +  (avg.isPresent() ? avg.getAsDouble() : 0)
                + "/" +  Collections.max(listOfTemperature)
                + "/" +  Collections.min(listOfTemperature));
    }

    @Override
    public void update() {
        float temp = weatherData.getTemperature();
        listOfTemperature.add(temp);
        display();
    }
}
