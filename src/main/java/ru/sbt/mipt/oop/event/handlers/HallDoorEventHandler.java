package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.scenarios.ScenarioController;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

public class HallDoorEventHandler implements SensorEventHandler {

    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smarthome) {

        this.smartHome = smarthome;
    }

    @Override
    public void handle(SensorEvent event) {

        ScenarioController scenarioController = new ScenarioController(smartHome);

        scenarioController.runCloseHallDoorScenario();
    }
}
