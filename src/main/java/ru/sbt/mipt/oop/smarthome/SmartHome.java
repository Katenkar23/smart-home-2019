package ru.sbt.mipt.oop.smarthome;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

    Collection<Room> rooms;
    AlarmSystem alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public AlarmSystem getAlarm() {
        return alarm;
    }

    public void setAlarm(AlarmSystem alarm) {
        this.alarm = alarm;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {

        action.run(this);

        alarm.execute(action);

        for (Room room : getRooms()) {
            room.execute(action);
        }
    }
}
