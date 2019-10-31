package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.smarthome.Door;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class DoorEventHandler implements SensorEventHandler {

    //    private final SensorEvent event;
    private final SmartHome smartHome;

    public DoorEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    // событие от двери
    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(event.getObjectId())) {
                        if (event.getType() == DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        }
                    }
                }
            }
        }
    }
}
