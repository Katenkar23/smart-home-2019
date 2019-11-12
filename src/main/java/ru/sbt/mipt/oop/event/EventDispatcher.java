package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.event.handlers.SensorEventHandler;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.util.ArrayList;

public class EventDispatcher {

    private SmartHome smartHome;
    private ArrayList<SensorEventHandler> sensorHandlers;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventDispatcher(SmartHome smartHome, ArrayList<SensorEventHandler> handlers) {
        this.smartHome = smartHome;
        this.sensorHandlers = handlers;
    }

    public void dispatch() {

        SensorEvent event = EventGenerator.getNextSensorEvent();

        // начинаем цикл обработки событий
        while (event != null) {

            System.out.println("Got new event " + event.toString());

            for (SensorEventHandler handler : sensorHandlers) {
                handler.handle(event);
            }

            event = EventGenerator.getNextSensorEvent();
        }
    }
}
