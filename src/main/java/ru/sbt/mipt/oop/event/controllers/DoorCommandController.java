package ru.sbt.mipt.oop.event.controllers;

import ru.sbt.mipt.oop.event.CommandType;
import ru.sbt.mipt.oop.event.SensorCommand;
import ru.sbt.mipt.oop.smarthome.SmartHome;

public class DoorCommandController implements HomeCommandController {

    private final SmartHome smartHome;

    public DoorCommandController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void action(SensorCommand command) {
        if (command.getType() == CommandType.DOOR_OPEN || command.getType() == CommandType.DOOR_CLOSED) {

        }
    }
}
