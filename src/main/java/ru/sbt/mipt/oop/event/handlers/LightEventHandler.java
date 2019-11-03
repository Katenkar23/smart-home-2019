package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.LightIterator;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightEventHandler implements SensorEventHandler {

    //    private final SensorEvent event;
    private final SmartHome smartHome;

    public LightEventHandler(SmartHome smarthome) {
//        this.event = event;
        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {

            LightIterator lightIterator = new LightIterator(smartHome);

            while (lightIterator.hasNext()) {

                Light light = lightIterator.next();

                if (light.equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room was opened.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room was closed.");
                    }
                }
            }
        }
    }
}
