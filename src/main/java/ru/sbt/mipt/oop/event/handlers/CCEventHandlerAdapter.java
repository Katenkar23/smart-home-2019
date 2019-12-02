package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;

import java.util.Collection;

public class CCEventHandlerAdapter implements EventHandler {

    private final Collection<SensorEventHandler> handlers;

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers) {
        this.handlers = handlers;
    }


    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);

        if (sensorEvent != null) {
            for (SensorEventHandler handler : handlers)
                handler.handle(sensorEvent);
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
