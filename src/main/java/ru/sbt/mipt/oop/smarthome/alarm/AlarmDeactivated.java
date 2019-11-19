package ru.sbt.mipt.oop.smarthome.alarm;

public class AlarmDeactivated implements AlarmSystemState {

    private final AlarmSystem alarm;

    public AlarmDeactivated(AlarmSystem alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
        alarm.setAlarmState(new AlarmActivated(alarm, code));
    }

    @Override
    public void deactivate(String code) {
    }

    @Override
    public void alert() {
        alarm.setAlarmState(new AlarmAlert(alarm));
    }
}
