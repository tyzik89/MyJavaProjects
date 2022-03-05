package com.work.vladimirs.patterns.command;

import com.work.vladimirs.patterns.command.commands.Command;

/**
 * Система управления устройствами дома с семью слотами управления.
 */
public class RemoteControl {

    Command[] commandsOn;
    Command[] commandsOff;
}
