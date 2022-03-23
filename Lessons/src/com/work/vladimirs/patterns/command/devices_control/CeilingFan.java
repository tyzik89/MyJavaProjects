package com.work.vladimirs.patterns.command.devices_control;

/**
 *  Управление вентилятором.
 *  Реализация отмены с состоянием.
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    // Локальная переменная состояния (скорость вращения вентилятора)
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        // Высокая скорость
        speed = HIGH;
        System.out.println(location +" ceiling fan is on high");
    }

    public void medium() {
        // Средняя скорость
        speed = MEDIUM;
        System.out.println(location +" ceiling fan is on medium");
    }

    public void low() {
        // Низкая скорость
        speed = LOW;
        System.out.println(location +" ceiling fan is on low");
    }

    public void off() {
        // Выключение вентилятора
        speed = OFF;
        System.out.println(location +" ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }
}
