package ru.sbt.mipt.oop;

public class LightCommandController implements HomeCommandController {

    private final SmartHome smartHome;

    public LightCommandController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void action(SensorCommand command) {
        if (command.getType() == CommandType.LIGHT_ON || command.getType() == CommandType.LIGHT_OFF) {

        }
    }
}
