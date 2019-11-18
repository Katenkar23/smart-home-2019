package ru.sbt.mipt.oop.smarthome;

public interface SmartHomeStateProvider {

    // считываем состояние дома
    SmartHome getHomeState();
}
