package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import java.util.Collection;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class CCEventHandlerAdapter implements EventHandler {

    private final AlarmSystemDecorator decorator;

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers, AlarmSystem alarm) {
        decorator = new AlarmSystemDecorator(handlers, alarm);
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);

        if (sensorEvent != null) {
            decorator.handle(sensorEvent);
        }
    }

    private SensorEvent adaptSensorEvent(CCSensorEvent event) {
        return new LigntOnTypeChooser(new LigntOffTypeChooser(new DoorOpenTypeChooser(new DoorClosedTypeChooser(new EmptyTypeChooser())))).adaptEvent(event);
    }

    //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"

    interface EventTypeChooser {
        SensorEvent adaptEvent(CCSensorEvent ccEvent);
    }

    class LigntOnTypeChooser implements EventTypeChooser {
        private final EventTypeChooser next;

        LigntOnTypeChooser(EventTypeChooser next) {
            this.next = next;
        }

        @Override
        public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
            if (ccEvent.getEventType().equals("LightIsOn")) {
                return new SensorEvent(LIGHT_ON, ccEvent.getObjectId());
            } else {
                return next.adaptEvent(ccEvent);
            }
        }
    }

    class LigntOffTypeChooser implements EventTypeChooser {
        private final EventTypeChooser next;

        LigntOffTypeChooser(EventTypeChooser next) {
            this.next = next;
        }

        @Override
        public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
            if (ccEvent.getEventType().equals("LightIsOff")) {
                return new SensorEvent(LIGHT_OFF, ccEvent.getObjectId());
            } else {
                return next.adaptEvent(ccEvent);
            }
        }
    }

    class DoorOpenTypeChooser implements EventTypeChooser {
        private final EventTypeChooser next;

        DoorOpenTypeChooser(EventTypeChooser next) {
            this.next = next;
        }

        @Override
        public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
            if (ccEvent.getEventType().equals("DoorIsOpen")) {
                return new SensorEvent(DOOR_OPEN, ccEvent.getObjectId());
            } else {
                return next.adaptEvent(ccEvent);
            }
        }
    }

    class DoorClosedTypeChooser implements EventTypeChooser {
        private final EventTypeChooser next;

        DoorClosedTypeChooser(EventTypeChooser next) {
            this.next = next;
        }

        @Override
        public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
            if (ccEvent.getEventType().equals("DoorIsClosed")) {
                return new SensorEvent(DOOR_CLOSED, ccEvent.getObjectId());
            } else {
                return next.adaptEvent(ccEvent);
            }
        }
    }

    class EmptyTypeChooser implements EventTypeChooser {

        @Override
        public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
            return null;
        }
    }
}
