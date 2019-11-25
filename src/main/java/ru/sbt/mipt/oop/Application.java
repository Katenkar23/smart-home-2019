package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;

public class Application {

    public static void main(String... args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);

        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);

        sensorEventsManager.start();
    }
}
