package ru.sbt.mipt.oop.smarthome.alarm;

public class AlarmActivated implements AlarmSystemState {

    private final AlarmSystem alarm;
    private final String code;

    public AlarmActivated(AlarmSystem alarm, String code) {
        this.alarm = alarm;
        this.code = code;
    }

    @Override
    public void activate(String code) {
    }

    @Override
    public void deactivate(String code) {
        if (this.code.equals(code)) {
            alarm.setAlarmState(new AlarmDeactivated(alarm));
        } else {
            alarm.setAlarmState(new AlarmAlert());
        }
    }

    @Override
    public void alert() {
        alarm.setAlarmState(new AlarmAlert());
    }
}
