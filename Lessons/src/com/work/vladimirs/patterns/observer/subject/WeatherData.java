package com.work.vladimirs.patterns.observer.subject;

import com.work.vladimirs.patterns.observer.observers.Observer;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Получение температуры с метеоприбора
     */
    @Override
    public float getTemperature() {
        return temperature;
    }

    /**
     * Получение влажности с метеоприбора
     */
    @Override
    public float getHumidity() {
        return humidity;
    }

    /**
     * Получение давления с метеоприбора
     */
    @Override
    public float getPressure() {
        return pressure;
    }

    /**
     * Оповещение наблюдаталей о появлении новых данных:
     * - текущее состояние;
     * - статистика;
     * - прогноз;
     */
    public void measurementsChanged() {
        notifyObserver();
    }

    /**
     * Чтение данных с метеостанции
     */
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
