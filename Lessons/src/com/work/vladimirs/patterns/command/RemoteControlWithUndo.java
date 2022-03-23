package com.work.vladimirs.patterns.command;

import com.work.vladimirs.patterns.command.commands.*;
import com.work.vladimirs.patterns.command.devices_control.CeilingFan;

public class RemoteControlWithUndo {

    // Команды хранятся в массиве
    CommandWithCancel[] onCommands;
    CommandWithCancel[] offCommands;

    // Last performed command
    CommandWithCancel undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new CommandWithCancel[7];
        offCommands = new CommandWithCancel[7];

        CommandWithCancel noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommand = noCommand;
    }

    public void setCommand(int slot, CommandWithCancel commandOn, CommandWithCancel commandOff) {
        onCommands[slot] = commandOn;
        offCommands[slot] = commandOff;

    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Remote Control With Undo -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "     " + offCommands[i].getClass().getSimpleName() + "\n");
        }
        return stringBuff.toString();
    }

    class NoCommand implements CommandWithCancel {

        @Override
        public void execute() {
            System.out.println("No command");
        }

        @Override
        public void undo() {
            System.out.println("No command");
        }
    }


    public static void main(String[] args) {
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        // Create instances of 3 command: for high speed, for medium speed and for turn off.
        CeilingFanMediumCommand ceilingFanMedium =
                new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh =
                new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff =
                new CeilingFanOffCommand(ceilingFan);

        remoteControlWithUndo.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remoteControlWithUndo.setCommand(1, ceilingFanHigh, ceilingFanOff);

        remoteControlWithUndo.onButtonWasPushed(0);
        remoteControlWithUndo.offButtonWasPushed(0);

        System.out.println(remoteControlWithUndo);

        remoteControlWithUndo.undoButtonWasPushed();
        remoteControlWithUndo.onButtonWasPushed(1);

        System.out.println(remoteControlWithUndo);

        remoteControlWithUndo.undoButtonWasPushed();
    }
}
