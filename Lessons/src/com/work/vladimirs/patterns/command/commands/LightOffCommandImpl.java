package com.work.vladimirs.patterns.command.commands;

import com.work.vladimirs.patterns.command.devices_control.Light;

public class LightOffCommandImpl implements Command {

    private Light light;

    public LightOffCommandImpl(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}
