package ru.sbt.mipt.oop.smarthome;

public interface AlarmSystemState {

    void activate(int code);

    void deactivate(int code);
}
