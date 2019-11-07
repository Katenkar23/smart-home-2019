package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.Setup;
import ru.sbt.mipt.oop.event.CCSensorEvent;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.EventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;

public class EventHandler implements SensorEventHandler {

    private SmartHome smartHome;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handle(CCSensorEvent event) {

        // экземпляр конфигурационного класса
        Setup setup = new Setup(this.getSmartHome());

        // начинаем цикл обработки событий
        while (event != null) {

            System.out.println("Got new event " + event.toString());

            setup.handle(event);

//            event = EventGenerator.getNextSensorEvent();
        }
    }
}
