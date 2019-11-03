package ru.sbt.mipt.oop.smarthome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LightIterator implements Iterator<Light> {

    private final SmartHome smartHome;
    private final List<Room> rooms;
    private int roomIndex;
    private int lightIndex;

    public LightIterator(SmartHome smartHome) {
        this.smartHome = smartHome;
        rooms = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (roomIndex < rooms.size()) {
            if (lightIndex < rooms.get(roomIndex).getLights().size() - 1) {
                return true;
            } else {
                roomIndex++;
                lightIndex = 0;
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public Light next() {
        if (hasNext()) {
            List<Light> lights = new ArrayList<>(rooms.get(roomIndex).getLights());
            return lights.get(++lightIndex);
        }

        return null;
    }
}
