package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;

// Обработчик событий сенсоров
public interface SensorEventHandler {

    void handle(SensorEvent event);
}
