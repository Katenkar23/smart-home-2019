package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmActivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmAlert;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import java.util.Collection;

import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_DEACTIVATE;

public class AlarmSystemDecorator implements SensorEventHandler {
    private final Collection<SensorEventHandler> delegates;
    private final AlarmSystem alarm;

    public AlarmSystemDecorator(Collection<SensorEventHandler> delegates, AlarmSystem alarm) {
        this.delegates = delegates;
        this.alarm = alarm;
    }

    @Override
    public void handle(SensorEvent event) {

        if (alarm.getAlarmState() instanceof AlarmDeactivated) {
            for (SensorEventHandler delegate : delegates)
                delegate.handle(event);
        } else if (alarm.getAlarmState() instanceof AlarmActivated) {
            if (event.getType() == ALARM_DEACTIVATE) {
                for (SensorEventHandler delegate : delegates)
                    delegate.handle(event);
            } else {
                alarm.alert();
                sendSMS(event);
            }
        } else if (alarm.getAlarmState() instanceof AlarmAlert) {
            if (event.getType() == ALARM_DEACTIVATE) {
                for (SensorEventHandler delegate : delegates)
                    delegate.handle(event);
            } else {
                sendSMS(event);
            }
        }
    }

    private void sendSMS(SensorEvent event) {
        System.out.println("Sending sms " + event.toString());
    }
}