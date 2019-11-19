package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.handlers.*;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.util.ArrayList;

// Класс, содержащий настройки умного дома
public class Setup {

    private ArrayList<SensorEventHandler> sensorHandlers;

    public Setup(SmartHome smartHome) {

        sensorHandlers = new ArrayList<>();

        // припоявлении нового обработчика событий, необходимо добавить его сюда
        sensorHandlers.add(new AlarmSystemEventHandler(smartHome));
        sensorHandlers.add(new DoorEventHandler(smartHome));
        sensorHandlers.add(new LightEventHandler(smartHome));
        sensorHandlers.add(new HallDoorEventHandler(smartHome));
    }

    public ArrayList<SensorEventHandler> getHandlers() {
        return sensorHandlers;
    }
}
