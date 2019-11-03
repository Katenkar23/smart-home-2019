package ru.sbt.mipt.oop.smarthome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoorIterator implements Iterator<Door> {

    private final SmartHome smartHome;
    private final List<Room> rooms;
    private int roomIndex;
    private int doorIndex;

    public DoorIterator(SmartHome smartHome) {
        this.smartHome = smartHome;
        rooms = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (roomIndex < rooms.size()) {
            if (doorIndex < rooms.get(roomIndex).getDoors().size() - 1) {
                return true;
            } else {
                roomIndex++;
                doorIndex = 0;
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public Door next() {
        if (hasNext()) {
            List<Door> doors = new ArrayList<>(rooms.get(roomIndex).getDoors());
            return doors.get(++doorIndex);
        }

        return null;
    }
}
