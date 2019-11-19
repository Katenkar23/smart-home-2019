package ru.sbt.mipt.oop.event;

public enum SensorEventType {

    ALARM_ACTIVATE("Active"), ALARM_DEACTIVATE("Active"), DOOR_CLOSED, DOOR_OPEN, LIGHT_OFF, LIGHT_ON;

    private String code;

    SensorEventType() {
    }

    SensorEventType(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
