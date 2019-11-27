package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.scenarios.ScenarioController;
import ru.sbt.mipt.oop.smarthome.SmartHome;

public class RcAllLightsOn implements RemoteCommand {

    private final SmartHome smartHome;

    public RcAllLightsOn(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        new ScenarioController(smartHome).runAllLightsOnScenario();
    }
}
