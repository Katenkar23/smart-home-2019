package ru.sbt.mipt.oop;

public class HallDoorCommandController implements HomeCommandController {

    private final SmartHome smartHome;

    public HallDoorCommandController(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void action(SensorCommand command) {
        ScenarioController scenarioController = new ScenarioController(smartHome);
        scenarioController.runCloseHallDoorScenario();
    }
}
