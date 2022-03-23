package com.work.vladimirs.patterns.command.commands;

import com.work.vladimirs.patterns.command.devices_control.CeilingFan;

public class CeilingFanHighCommand implements CommandWithCancel {

    private CeilingFan ceilingFan;
    // Локальная переменная состояния (скорость вращения вентилятора)
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    /**
     * Возвращение к предыдущей скорости вентилятора
     */
    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
