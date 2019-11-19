package ru.sbt.mipt.oop.smarthome.alarm;

public class AlarmAlert implements AlarmSystemState {

    private final AlarmSystem alarm;

    public AlarmAlert(AlarmSystem alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (alarm.verifyCode(code)) {
            alarm.setAlarmState(new AlarmDeactivated(alarm));
        }
    }

    @Override
    public void alert() {
    }
}
