package ru.sbt.mipt.oop.event.eventtypechooser;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightOnTypeChooser implements EventTypeChooser {

    private final EventTypeChooser next;

    public LightOnTypeChooser(EventTypeChooser next) {
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
