package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventHandler implements SensorEventHandler {

    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            SensorCommand command = new SensorCommand(event);

            HallDoorCommandController hallDoorController = new HallDoorCommandController(smartHome);

            hallDoorController.action(command);
        }
    }
}
