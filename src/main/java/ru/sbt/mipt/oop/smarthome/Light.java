package ru.sbt.mipt.oop.smarthome;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Light implements Actionable {

    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void execute(Action action) {
        SensorEvent event = action.getEvent();

        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            if (this.getId().equals(event.getObjectId())) {
                if (event.getType() == LIGHT_ON) {
                    this.setOn(true);
                    System.out.println("\tLight " + this.getId() + " was turned on.");
                    //System.out.println("Light " + this.getId() + " in room " + room.getName() + " was turned on.");
                } else {
                    this.setOn(false);
                    System.out.println("\tLight " + this.getId() + " was turned off.");
                    //System.out.println("Light " + this.getId() + " in room " + room.getName() + " was turned off.");
                }
            }
        }
    }
}
