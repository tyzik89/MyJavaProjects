package com.work.vladimirs.patterns.command.commands;

import com.work.vladimirs.patterns.command.devices_control.GarageDoor;

public class GarageDoorOpenCommandImpl implements Command {

    private GarageDoor garageDoor;

    public GarageDoorOpenCommandImpl(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
