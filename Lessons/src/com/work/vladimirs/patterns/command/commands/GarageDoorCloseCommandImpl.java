package com.work.vladimirs.patterns.command.commands;

import com.work.vladimirs.patterns.command.devices_control.GarageDoor;

public class GarageDoorCloseCommandImpl implements Command {

    private GarageDoor garageDoor;

    public GarageDoorCloseCommandImpl(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
        garageDoor.lightOff();
    }
}
