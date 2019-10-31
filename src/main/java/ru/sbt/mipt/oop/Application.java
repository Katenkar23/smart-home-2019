package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.handlers.EventHandler;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        // считываем состояние дома из файла
        JsonSmartHomeStateProvider smartHomeStateProvider = new JsonSmartHomeStateProvider("smart-home-1.js");
        SmartHome smartHome = smartHomeStateProvider.getHomeState();

        EventHandler eventHandler = new EventHandler(smartHome);

        eventHandler.controlEvent();
    }
}
