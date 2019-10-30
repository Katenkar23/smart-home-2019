package ru.sbt.mipt.oop.smarthome;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.event.*;
import ru.sbt.mipt.oop.event.handlers.DoorEventHandler;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class Door implements Actionable {

    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void execute(Action action) {
        SensorEvent event = action.getEvent();

        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            if (this.getId().equals(event.getObjectId())) {
                if (event.getType() == DOOR_OPEN) {
                    this.setOpen(true);
                    System.out.println("\tDoor " + this.getId() + " was opened.");
                    //System.out.println("Door " + this.getId() + " in room " + room.getName() + " was opened.");
                } else {
                    this.setOpen(false);
                    System.out.println("\tDoor " + this.getId() + " was closed.");
                    //System.out.println("Door " + this.getId() + " in room " + room.getName() + " was closed.");
                }
            }
        }
    }
}
