package ru.sbt.mipt.oop.event.adapt;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;

public class LightOffTypeChooser implements EventTypeChooser {
    private final EventTypeChooser next;

    public LightOffTypeChooser(EventTypeChooser next) {
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