package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.event.eventtypechooser.*;
import ru.sbt.mipt.oop.event.handlers.*;
import ru.sbt.mipt.oop.event.manager.SensorEventsManager;
import ru.sbt.mipt.oop.remotecontrol.*;
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
        seManager.registerEventHandler(new CCEventHandlerAdapter(handlers, lightOnTypeChooser(), alarmSystem()));
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

    @Bean
    RemoteControlImpl remoteControl() {
        RemoteControlImpl rc = new RemoteControlImpl();

        rc.addCommand("A", new RcAllLightsOn(smartHome()));
        rc.addCommand("B", new RcAllLightsOff(smartHome()));
        rc.addCommand("C", new RcHallLightOn(smartHome()));
        rc.addCommand("D", new RcCloseHallDoor(smartHome()));
        rc.addCommand("1", new RcAlarmActivate(smartHome()));
        rc.addCommand("2", new RcAlarmAlert(smartHome()));

        return rc;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        RemoteControlRegistry rcRegistry = new RemoteControlRegistry();

        rcRegistry.registerRemoteControl(remoteControl(), "rc001");

        return rcRegistry;
    }

    @Bean
    EmptyTypeChooser emptyTypeChooser() {
        return new EmptyTypeChooser();
    }

    @Bean
    DoorClosedTypeChooser doorClosedTypeChooser() {
        return new DoorClosedTypeChooser(emptyTypeChooser());
    }

    @Bean
    DoorOpenTypeChooser doorOpenTypeChooser() {
        return new DoorOpenTypeChooser(doorClosedTypeChooser());
    }

    @Bean
    LightOffTypeChooser lightOffTypeChooser() {
        return new LightOffTypeChooser(doorOpenTypeChooser());
    }

    @Bean
    LightOnTypeChooser lightOnTypeChooser() {
        return new LightOnTypeChooser(lightOffTypeChooser());
    }
}
