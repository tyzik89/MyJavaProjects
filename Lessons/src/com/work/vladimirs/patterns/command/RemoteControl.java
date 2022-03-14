package com.work.vladimirs.patterns.command;

import com.work.vladimirs.patterns.command.commands.Command;

/**
 * Система управления устройствами дома с семью слотами управления.
 */
public class RemoteControl {

    // Команды хранятся в массиве
    Command[] commandsOn;
    Command[] commandsOff;

    public RemoteControl() {
        commandsOn = new Command[7];
        commandsOff = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            commandsOn[i] = noCommand;
            commandsOff[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command commandOn, Command commandOff) {
        commandsOn[slot] = commandOn;
        commandsOff[slot] = commandOff;

    }

    public void onButtonWasPushed(int slot) {
        commandsOn[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        commandsOff[slot].execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control -------\n");
        for (int i = 0; i < commandsOn.length; i++) {
            stringBuff.append("[slot " + i + "] " + commandsOn[i].getClass().getName()
                    + " " + commandsOff[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}
