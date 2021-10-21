package com.work.vladimirs.patterns.observer;

public class WeatherData {

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
