package ru.sbt.mipt.oop;

public class EventController {

    private SmartHome smartHome;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventController(SmartHome smartHome) {
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
