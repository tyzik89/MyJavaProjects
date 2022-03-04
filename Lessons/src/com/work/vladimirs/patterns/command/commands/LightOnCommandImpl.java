package com.work.vladimirs.patterns.command.commands;

import com.work.vladimirs.patterns.command.devices_control.Light;

public class LightOnCommandImpl implements Command{

    private Light light;

    public LightOnCommandImpl(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }
}
