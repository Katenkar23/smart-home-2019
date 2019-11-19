package ru.sbt.mipt.oop.smarthome.alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class AlarmSystem implements Actionable, AlarmSystemState {

    private AlarmSystemState alarmState;
    private final String code;

    public AlarmSystem(String code) {
        this.code = code;
    }

    public AlarmSystemState getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(AlarmSystemState alarmState) {
        this.alarmState = alarmState;
    }

    @Override
    public void execute(Action action) {
        action.run(this);
    }

    @Override
    public void activate(String code) {
        alarmState.activate(code);
    }

    @Override
    public void deactivate(String code) {
        alarmState.deactivate(code);
    }

    @Override
    public void alert() {
        alarmState.alert();
    }
}
