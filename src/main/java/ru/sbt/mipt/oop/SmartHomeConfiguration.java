package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.event.handlers.*;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import java.util.Collection;

@Configuration
public class SmartHomeConfiguration {

    @Bean
    SmartHome smartHome() {
        return new JsonSmartHomeStateProvider("smart-home-1.js").getHomeState();
    }

    @Bean
    AlarmSystem alarmSystem() {
        return smartHome().getAlarm();
    }

    @Bean
    SensorEventsManager sensorEventsManager(Collection<SensorEventHandler> handlers) {
        SensorEventsManager seManager = new SensorEventsManager();
        seManager.registerEventHandler(new CCEventHandlerAdapter(handlers));
        return seManager;
    }

    @Bean
    SensorEventHandler alarmHandler() {
        return new AlarmSystemEventHandler(smartHome());
    }

    @Bean
    SensorEventHandler lightHandler() {
        return new LightEventHandler(smartHome());
    }

    @Bean
    SensorEventHandler doorHandler() {
        return new DoorEventHandler(smartHome());
    }

    @Bean
    SensorEventHandler hallDoorHandler() {
        return new HallDoorEventHandler(smartHome());
    }
}
