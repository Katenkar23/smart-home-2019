package ru.sbt.mipt.oop.event.handlers;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.smarthome.Door;
import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;

class HallDoorEventHandlerTest {

    @Test
    void testHallDoorHandle() {

        SmartHome smartHome = new SmartHome();

        String lightId1 = "1";
        String lightId2 = "2";
        String doorId = "4";

        Light light1 = new Light(lightId1, true);
        Light light2 = new Light(lightId2, true);
        Door door = new Door(doorId, false);

        smartHome.addRoom(new Room(Arrays.asList(light1, light2), Arrays.asList(door), "hall"));

        HallDoorEventHandler hallHandler = new HallDoorEventHandler(smartHome);

        hallHandler.handle(new SensorEvent(DOOR_CLOSED, doorId));

        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
    }
}