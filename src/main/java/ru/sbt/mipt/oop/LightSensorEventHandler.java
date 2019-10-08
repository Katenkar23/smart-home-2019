package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightSensorEventHandler implements SensorEventHandler {

    private final SensorEvent event;
    private final SmartHome smartHome;

    public LightSensorEventHandler(SensorEvent event, SmartHome smarthome) {
        this.event = event;
        this.smartHome = smarthome;
    }

    @Override
    public void Handle() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
