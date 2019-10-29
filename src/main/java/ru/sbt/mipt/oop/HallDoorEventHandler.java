package ru.sbt.mipt.oop;

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
