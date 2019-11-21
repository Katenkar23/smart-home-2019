package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.EventDispatcher;
import ru.sbt.mipt.oop.event.handlers.CCEventHandlerAdapter;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;

public class Application {

    public static void main(String... args) {

        // считываем состояние дома из файла
        JsonSmartHomeStateProvider smartHomeStateProvider = new JsonSmartHomeStateProvider("smart-home-1.js");
        SmartHome smartHome = smartHomeStateProvider.getHomeState();

        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new CCEventHandlerAdapter(smartHome));
        sensorEventsManager.start();
    }
}
