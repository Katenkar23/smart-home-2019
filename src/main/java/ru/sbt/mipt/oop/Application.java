package ru.sbt.mipt.oop;

import java.io.IOException;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {

        // считываем состояние дома из файла
        JsonSmartHomeStateProvider smartHomeStateProvider = new JsonSmartHomeStateProvider("smart-home-1.js");
        SmartHome smartHome = smartHomeStateProvider.getHomeState();

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                // событие от источника света
                LightSensorEventHandler lightHandler = new LightSensorEventHandler(event, smartHome);
                lightHandler.handle();
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                // событие от двери
                DoorSensorEventHandler doorHandler = new DoorSensorEventHandler(event, smartHome);
                doorHandler.handle();
            }
            event = getNextSensorEvent();
        }
    }

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
