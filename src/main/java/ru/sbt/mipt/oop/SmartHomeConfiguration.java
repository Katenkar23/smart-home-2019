package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.event.handlers.CCEventHandlerAdapter;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;
import ru.sbt.mipt.oop.smarthome.JsonSmartHomeStateProvider;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

@Configuration
public class SmartHomeConfiguration {

    @Bean
    SmartHome smartHome() {
        return new JsonSmartHomeStateProvider("smart-home-1.js").getHomeState();
    }

    @Bean
    CCEventHandlerAdapter ccEventHandlerAdapter() {
        return new CCEventHandlerAdapter(smartHome());
    }

    @Bean
    AlarmSystem alarmSystem() {
        return smartHome().getAlarm();
    }

    @Bean
    SensorEventsManager sensorEventsManager() {
        SensorEventsManager seManager = new SensorEventsManager();
        seManager.registerEventHandler(ccEventHandlerAdapter());
        return seManager;
    }
}
