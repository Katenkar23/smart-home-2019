package ru.sbt.mipt.oop;

import java.util.ArrayList;

// Класс, содержащий настройки умного дома
public class Setup {

    private ArrayList<SensorEventHandler> sensorHandlers;

    public Setup(SmartHome smartHome) {

        sensorHandlers = new ArrayList<>();

        // припоявлении нового обработчика событий, необходимо добавить его сюда
        sensorHandlers.add(new DoorEventHandler(smartHome));
        sensorHandlers.add(new LightEventHandler(smartHome));
    }

    public void handle(SensorEvent event) {

        for (SensorEventHandler eh : sensorHandlers) {
            eh.handle(event);
        }
    }
}
