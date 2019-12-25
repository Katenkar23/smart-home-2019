package ru.sbt.mipt.oop.event.eventtypechooser;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

public class EmptyTypeChooser implements EventTypeChooser {

    @Override
    public SensorEvent adaptEvent(CCSensorEvent ccEvent) {
        return null;
    }
}