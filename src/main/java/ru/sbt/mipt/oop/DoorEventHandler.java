package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements SensorEventHandler {

    //    private final SensorEvent event;
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от двери
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            SensorCommand command = new SensorCommand(event);

            DoorCommandController doorController = new DoorCommandController(smartHome);

            doorController.action(command);
        }
    }
}
