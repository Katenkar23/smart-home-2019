package ru.sbt.mipt.oop.event.eventtypechooser;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

public class DoorOpenTypeChooser implements EventTypeChooser {

    private final EventTypeChooser next;

    public DoorOpenTypeChooser(EventTypeChooser next) {
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