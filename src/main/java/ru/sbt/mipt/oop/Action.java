package ru.sbt.mipt.oop;

public class Action {

    private SensorEvent event;

    public Action(SensorEvent event) {
        this.event = event;
    }

    SensorEvent getEvent() {
        return event;
    }
}
