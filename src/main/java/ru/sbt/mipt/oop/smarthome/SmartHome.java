package ru.sbt.mipt.oop.smarthome;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
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

        for (Room room : getRooms()) {
            room.execute(action);
        }
    }
}
