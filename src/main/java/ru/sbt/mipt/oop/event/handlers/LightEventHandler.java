package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightEventHandler implements SensorEventHandler {

    //    private final SensorEvent event;
    private final SmartHome smartHome;

    public LightEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            smartHome.execute(actionable -> {
                if (actionable instanceof Light) {
                    Light light = (Light) actionable;
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room was on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room was off.");
                        }
                    }
                }
            });
        }
    }
}