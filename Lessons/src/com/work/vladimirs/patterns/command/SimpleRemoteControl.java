package com.work.vladimirs.patterns.command;

import com.work.vladimirs.patterns.command.commands.Command;
import com.work.vladimirs.patterns.command.commands.LightOnCommandImpl;
import com.work.vladimirs.patterns.command.devices_control.Light;

/**
 * Система управления устройствами дома с одним слотом (1 кнопка отвечает за какое-либо действие механизма/устройтва)
 */
public class SimpleRemoteControl {

    /**
     * Одно управляемое устройство
     */
    Command slot;

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        if (slot != null) {
            slot.execute();
        }
    }

    public static void main(String[] args) {
        // Инициатор, ему передаётся объект команды
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        // Получатель запроса
        Light light = new Light();
        // Команда, с указанием получателя
        LightOnCommandImpl lightOnCommand = new LightOnCommandImpl(light);

        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}