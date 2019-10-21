package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

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
                    //System.out.println("Door " + this.getId() + " in room " + room.getName() + " was opened.");
                } else {
                    this.setOpen(false);
                    //System.out.println("Door " + this.getId() + " in room " + room.getName() + " was closed.");
                }
            }
        }
    }
}
