package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;

public class CCEventHandlerAdapter implements EventHandler {

    private final SensorEventHandler adaptee;

    public CCEventHandlerAdapter(SensorEventHandler adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);
        if (sensorEvent != null){
            adaptee.handle(sensorEvent);
        }
    }

    private SensorEvent adaptSensorEvent(CCSensorEvent event) {

        //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"

        if (event.getEventType().equals("LightIsOn")) {
            return new SensorEvent(SensorEventType.LIGHT_ON, event.getObjectId());
        }
        if (event.getEventType().equals("LightIsOff")) {
            return new SensorEvent(SensorEventType.LIGHT_OFF, event.getObjectId());
        }
        if (event.getEventType().equals("DoorIsOpen")) {
            return new SensorEvent(SensorEventType.DOOR_OPEN, event.getObjectId());
        }
        if (event.getEventType().equals("DoorIsClosed")) {
            return new SensorEvent(SensorEventType.DOOR_CLOSED, event.getObjectId());
        }

        return null;
    }
}
