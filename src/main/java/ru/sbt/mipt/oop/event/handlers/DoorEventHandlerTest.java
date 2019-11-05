package ru.sbt.mipt.oop.event.handlers;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.smarthome.Door;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

class DoorEventHandlerTest {

    @Test
    public void testWorkHandlerFalse() throws Exception {

        SmartHome smartHome = new SmartHome();

        String doorId = "1";

        Door door = new Door(false, doorId);

        smartHome.addRoom(new Room(Collections.emptyList(), Arrays.asList(door), "hall"));

        DoorEventHandler doorHandler = new DoorEventHandler(smartHome);

        SensorEvent event = new SensorEvent(DOOR_OPEN, doorId);

        doorHandler.handle(event);

        event = new SensorEvent(DOOR_CLOSED, doorId);

        doorHandler.handle(event);

        assertFalse(door.isOpen());
    }

    @Test
    void testWorkHandlerTrue() {

        SmartHome smartHome = new SmartHome();

        String doorId = "1";

        Door door = new Door(false, doorId);

        smartHome.addRoom(new Room(Collections.emptyList(), Arrays.asList(door), "hall"));

        DoorEventHandler doorHandler = new DoorEventHandler(smartHome);

        SensorEvent event = new SensorEvent(DOOR_CLOSED, doorId);

        doorHandler.handle(event);

        event = new SensorEvent(DOOR_OPEN, doorId);

        doorHandler.handle(event);

        assertTrue(door.isOpen());
    }
}