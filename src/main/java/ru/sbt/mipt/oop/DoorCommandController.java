package ru.sbt.mipt.oop;

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
