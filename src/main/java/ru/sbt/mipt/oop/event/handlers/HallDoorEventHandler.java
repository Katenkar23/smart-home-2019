package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.scenarios.ScenarioController;
import ru.sbt.mipt.oop.smarthome.Door;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;

public class HallDoorEventHandler implements SensorEventHandler {

    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    @Override
    public void handle(SensorEvent event) {
        if (event.getType() == DOOR_CLOSED) {

            smartHome.execute(actionable -> {
                if (actionable instanceof Room) {

                    Room room = (Room) actionable;

                    if (room.getName().equals("hall")) {

                        room.execute(hallActionable -> {
                            if (hallActionable instanceof Door) {

                                Door door = (Door) hallActionable;

                                if (door.getId().equals(event.getObjectId())) {
                                    if (event.getType() == DOOR_CLOSED) {

                                        door.setOpen(false);

                                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed. HallDoor!");

                                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                                        ScenarioController scenarioController = new ScenarioController(smartHome);

                                        scenarioController.runAllLightsOffScenario();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
