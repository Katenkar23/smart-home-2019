package ru.sbt.mipt.oop.event.adapt;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;

public class DoorClosedTypeChooser implements EventTypeChooser {

    private final EventTypeChooser next;

    public DoorClosedTypeChooser(EventTypeChooser next) {
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