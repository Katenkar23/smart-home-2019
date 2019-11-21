package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.event.handlers.CCEventHandlerAdapter;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;

public class Application {

//    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String... args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);

        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
    }
}
