package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class AlarmSystemEventHandler implements SensorEventHandler {

    private final SmartHome smartHome;

    public AlarmSystemEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от источника света
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE) {
            smartHome.execute(actionable -> {
                if (actionable instanceof AlarmSystem) {
                    AlarmSystem alarm = (AlarmSystem) actionable;
                    if (alarm.getId().equals(event.getObjectId())) {
                        if (event.getType() == ALARM_ACTIVATE) {
                            alarm.activate(ALARM_ACTIVATE.getCode());
                            System.out.println("Alarm " + alarm.getId() + " activated.");
                        } else {
                            alarm.deactivate(ALARM_DEACTIVATE.getCode());
                            System.out.println("Alarm " + alarm.getId() + " deactivated.");
                        }
                    }
                }
            });
        }
    }
}
