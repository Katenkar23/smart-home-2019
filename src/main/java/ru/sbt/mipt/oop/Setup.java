package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

// Класс, содержащий настройки умного дома
public class Setup {

    private List<SensorEventHandler> sensorHandlers;

    public Setup(SmartHome smartHome) {

        List<SensorEventHandler> sensorHandlers = new ArrayList<>();

        // припоявлении нового обработчика событий, необходимо добавить его сюда
        sensorHandlers.add(new DoorSensorEventHandler(smartHome));
        sensorHandlers.add(new LightSensorEventHandler(smartHome));
    }

    public void handle(SensorEvent event) {

        for (SensorEventHandler eh : sensorHandlers) {
            eh.handle(event);
        }
    }
}
