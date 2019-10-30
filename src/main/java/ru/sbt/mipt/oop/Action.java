package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.SensorEvent;

public class Action {

    private SensorEvent event;

    public Action(SensorEvent event) {
        this.event = event;
    }

    public SensorEvent getEvent() {
        return event;
    }
}
