package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmActivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmAlert;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_DEACTIVATE;

public class AlarmSystemDecorator implements SensorEventHandler {

    private final SensorEventHandler delegate;
    private final AlarmSystem alarm;

    public AlarmSystemDecorator(SensorEventHandler delegate, AlarmSystem alarm) {
        this.delegate = delegate;
        this.alarm = alarm;
    }

    @Override
    public void handle(SensorEvent event) {

        if (alarm.getAlarmState() instanceof AlarmDeactivated) {
            delegate.handle(event);
        } else if (alarm.getAlarmState() instanceof AlarmActivated) {
            alarm.alert();
            System.out.println("Sending sms " + event.toString());
            delegate.handle(event);
        } else if (alarm.getAlarmState() instanceof AlarmAlert) {
            System.out.println("Sending sms " + event.toString());
        }
    }
}
