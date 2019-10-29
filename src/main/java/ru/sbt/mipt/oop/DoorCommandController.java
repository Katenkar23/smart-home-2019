package ru.sbt.mipt.oop;

public class DoorCommandController implements HomeCommandController {

    private final SmartHome smartHome;

    public DoorCommandController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void action(SensorCommand command) {
        if (command.getType() == CommandType.DOOR_OPEN || command.getType() == CommandType.DOOR_CLOSED) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    if (door.getId().equals(command.getObjectId())) {
                        if (command.getType() == CommandType.DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                            if (room.getName().equals("hall")) {

                                HallDoorCommandController hallDoorController = new HallDoorCommandController(smartHome);

                                hallDoorController.action(command);
                            }
                        }
                    }
                }
            }
        }
    }
}
