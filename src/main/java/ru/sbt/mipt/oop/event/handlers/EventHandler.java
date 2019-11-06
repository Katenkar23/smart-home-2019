package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.Setup;
import ru.sbt.mipt.oop.event.CCSensorEvent;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.EventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;

import java.util.ArrayList;

public class EventHandler implements SensorEventHandler {

    private SmartHome smartHome;
    private ArrayList<SensorEventHandler> sensorHandlers;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventHandler(SmartHome smartHome, ArrayList<SensorEventHandler> handlers) {
        this.smartHome = smartHome;
        this.sensorHandlers = handlers;
    }

    @Override
    public void handle(CCSensorEvent event) {

        // начинаем цикл обработки событий
        while (event != null) {

            System.out.println("Got new event " + event.toString());

            for (SensorEventHandler handler : sensorHandlers) {
                handler.handle(event);
            }

//            event = EventGenerator.getNextSensorEvent();
        }
    }
}
