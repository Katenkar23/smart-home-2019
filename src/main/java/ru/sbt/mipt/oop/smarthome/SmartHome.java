package ru.sbt.mipt.oop.smarthome;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.event.*;
import ru.sbt.mipt.oop.scenarios.ScenarioController;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        for (Room room : rooms) {

            room.execute(action);

            // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
            // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
            if (room.getName().equals("hall") && action.getEvent().getType().equals(SensorEventType.DOOR_CLOSED)) {
                ScenarioController scenarioController = new ScenarioController(this);
                scenarioController.runAllLightsOffScenario();
            }
        }
    }
}
