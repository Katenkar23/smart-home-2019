package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightSensorEventHandler implements SensorEventHandler {

    //    private final SensorEvent event;
    private final SmartHome smartHome;

    public LightSensorEventHandler(SmartHome smarthome) {
//        this.event = event;
        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            SensorCommand command = new SensorCommand(event);

            LightCommandController lightController = new LightCommandController(smartHome);

            lightController.action(command);
        }
    }
}
