package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        // считываем состояние дома из файла
        JsonSmartHomeStateProvider smartHomeStateProvider = new JsonSmartHomeStateProvider("smart-home-1.js");
        SmartHome smartHome = smartHomeStateProvider.getHomeState();

        EventController eventController = new EventController(smartHome);

        eventController.controlEvent();
    }
}
