package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.event.EventGenerator;
import ru.sbt.mipt.oop.event.CCSensorEvent;
import ru.sbt.mipt.oop.event.SensorEventsManager;
import ru.sbt.mipt.oop.event.handlers.EventHandler;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        // считываем состояние дома из файла
        JsonSmartHomeStateProvider smartHomeStateProvider = new JsonSmartHomeStateProvider("smart-home-1.js");
        SmartHome smartHome = smartHomeStateProvider.getHomeState();

//        EventHandler eventHandler = new EventHandler(smartHome);

//        eventHandler.handle(EventGenerator.getNextSensorEvent());

        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.start();
    }
}
