package ru.sbt.mipt.oop.smarthome.alarm;

public interface AlarmSystemState {

    void activate(int code);

    void deactivate(int code);

    void alert();
}
