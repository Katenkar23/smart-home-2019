package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;

import java.util.Collection;
import java.util.HashMap;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class CCEventHandlerAdapter implements EventHandler {

    private final Collection<SensorEventHandler> handlers;
    private final HashMap<String, SensorEventType> eventMap;

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers) {
        this.handlers = handlers;
        this.eventMap = new HashMap<>();

        setEventMap();
    }

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers, HashMap<String, SensorEventType> eventMap) {
        this.handlers = handlers;
        this.eventMap = eventMap;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);

        if (sensorEvent != null) {
            for (SensorEventHandler handler : handlers)
                handler.handle(sensorEvent);
        }
    }

    private void setEventMap() {

        //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"

        eventMap.put("LightIsOn", LIGHT_ON);
        eventMap.put("LightIsOff", LIGHT_OFF);
        eventMap.put("DoorIsOpen", DOOR_OPEN);
        eventMap.put("DoorIsClosed", DOOR_CLOSED);
    }

    private SensorEvent adaptSensorEvent(CCSensorEvent event) {

        //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"

        if (eventMap.get(event.getEventType()) != null) {
            return new SensorEvent(eventMap.get(event.getEventType()), event.getObjectId());
        }

        return null;
    }
}
