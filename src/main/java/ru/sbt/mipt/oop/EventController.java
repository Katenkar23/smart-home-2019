package ru.sbt.mipt.oop;

public class EventController {

    private SmartHome smartHome;

    private SmartHome getSmartHome() {
        return smartHome;
    }

    public EventController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    private static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }

    public void controlEvent() {

        // экземпляр конфигурационного класса
        Setup setup = new Setup(this.getSmartHome());

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        while (event != null) {

            setup.handle(event);

            event = getNextSensorEvent();
        }
    }
}
