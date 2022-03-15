package com.work.vladimirs.patterns.command.devices_control;

/**
 * Управление осветительной системой
 */
public class Light {

    private String placeName;

    public Light(String placeName) {
        this.placeName = placeName;
    }

    public void lightOn() {
        System.out.println(placeName + ". Light on");
    }

    public void lightOff() {
        System.out.println(placeName + ". Light off");
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
