package com.work.vladimirs.patterns.observer.subject;

import com.work.vladimirs.patterns.observer.observers.Observer;

public class WeatherData implements Subject {

    @Override
    public void registerObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObserver() {

    }

    /**
     * Получение температуры с метеоприбора
     */
    public void getTemperature() {}

    /**
     * Получение влажности с метеоприбора
     */
    public void getHumidity() {}

    /**
     * Получение давления с метеоприбора
     */
    public void getPressure() {}

    /**
     * Обновление изображения для трёх элементов:
     * - текущее состояние;
     * - статистика;
     * - прогноз;
     */
    public void measurementsChanged() {

    }
}
