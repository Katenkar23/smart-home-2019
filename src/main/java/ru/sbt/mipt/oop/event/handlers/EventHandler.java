package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.Setup;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.EventGenerator;
import ru.sbt.mipt.oop.event.SensorEvent;

public class EventHandler {

    private SmartHome smartHome;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void controlEvent() {

        // экземпляр конфигурационного класса
        Setup setup = new Setup(this.getSmartHome());

        // начинаем цикл обработки событий
        SensorEvent event = EventGenerator.getNextSensorEvent();
        while (event != null) {

            setup.handle(event);

            event = EventGenerator.getNextSensorEvent();
        }
    }
}
