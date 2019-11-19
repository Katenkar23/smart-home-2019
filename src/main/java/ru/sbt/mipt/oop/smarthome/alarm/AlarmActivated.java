package ru.sbt.mipt.oop.smarthome.alarm;

public class AlarmActivated implements AlarmSystemState {

    private final AlarmSystem alarm;

    public AlarmActivated(AlarmSystem alarm, String code) {
        this.alarm = alarm;
        this.alarm.setCode(code);
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (alarm.verifyCode(code)) {
            alarm.setAlarmState(new AlarmDeactivated(alarm));
        } else {
            alarm.setAlarmState(new AlarmAlert(alarm));
        }
    }

    @Override
    public void alert() {
        alarm.setAlarmState(new AlarmAlert(alarm));
    }
}
