package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorSensorEventHandler implements SensorEventHandler {

    private final SensorEvent event;
    private final SmartHome smartHome;

    public DoorSensorEventHandler(SensorEvent event, SmartHome smarthome) {
        this.event = event;
        this.smartHome = smarthome;
    }

    @Override
    public void handle() {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        if (room.getName().equals("hall")) {
                            LightSensorEventHandler lightHandler = new LightSensorEventHandler(event, smartHome);
                            lightHandler.allLightOff();
                        }
                    }
                }
            }
        }
    }
}
