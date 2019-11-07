package ru.sbt.mipt.oop.event.controllers;

import ru.sbt.mipt.oop.event.SensorCommand;

public interface HomeCommandController {

    public void control(SensorCommand command);

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
