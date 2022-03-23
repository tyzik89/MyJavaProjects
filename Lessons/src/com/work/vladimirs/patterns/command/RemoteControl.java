package com.work.vladimirs.patterns.command;

import com.work.vladimirs.patterns.command.commands.*;
import com.work.vladimirs.patterns.command.devices_control.GarageDoor;
import com.work.vladimirs.patterns.command.devices_control.Light;
import com.work.vladimirs.patterns.command.devices_control.Radio;

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
            stringBuff.append("[slot " + i + "] " + commandsOn[i].getClass().getSimpleName()
                    + "     " + commandsOff[i].getClass().getSimpleName() + "\n");
        }
        return stringBuff.toString();
    }

    class NoCommand implements Command {

        @Override
        public void execute() {
            System.out.println("No command");
        }
    }

    public static void main(String[] args) {
        // Devices creation
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor();
        Radio radio = new Radio();

        // Create commands for manage light system
        LightOnCommandImpl livingRoomLightOn =
                new LightOnCommandImpl(livingRoomLight);
        LightOffCommandImpl livingRoomLightOff =
                new LightOffCommandImpl(livingRoomLight);
        LightOnCommandImpl kitchenLightOn =
                new LightOnCommandImpl(kitchenLight);
        LightOffCommandImpl kitchenLightOff =
                new LightOffCommandImpl(kitchenLight);


        // Create commands for garage door
        GarageDoorOpenCommandImpl garageDoorUp =
                new GarageDoorOpenCommandImpl(garageDoor);
        GarageDoorCloseCommandImpl garageDoorDown =
                new GarageDoorCloseCommandImpl(garageDoor);


        // Binding commands to buttons remote control's
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
        // Create and binding lambda commands for radio (without concrete command)
        remoteControl.setCommand(3, () -> radio.radioOn(), radio::radioOff);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
    }

}
