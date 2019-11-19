package ru.sbt.mipt.oop.smarthome.alarm;

public interface AlarmSystemState {

    void activate(String code);

    void deactivate(String code);

    void alert();
}
