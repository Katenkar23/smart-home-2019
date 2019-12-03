package ru.sbt.mipt.oop.remotecontrol;

import rc.RemoteControl;

import java.util.HashMap;

public class RemoteControlImpl implements RemoteControl {

    HashMap<String, RemoteCommand> buttonsCommand;

    public RemoteControlImpl() {

        this.buttonsCommand = new HashMap<>();
    }

    public void addCommand(String button, RemoteCommand command) {

        buttonsCommand.put(button, command);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        try {
            RemoteCommand command = buttonsCommand.get(buttonCode);
            command.execute();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
