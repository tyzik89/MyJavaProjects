package com.work.vladimirs.patterns.command.devices_control;

public class GarageDoor {

    public void up() {
        System.out.println("Door is up");
    }

    public void down() {
        System.out.println("Door is down");
    }

    public void stop() {
            System.out.println("Door is stop");
    }

    public void lightOn() {
        System.out.println("Light in garage on");
    }

    public void lightOff() {
        System.out.println("Light in garage off");
    }
}
