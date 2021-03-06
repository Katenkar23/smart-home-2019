package ru.sbt.mipt.oop.scenarios;

import ru.sbt.mipt.oop.event.CommandType;
import ru.sbt.mipt.oop.event.SensorCommand;
import ru.sbt.mipt.oop.event.CommandSender;
import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.SmartHome;

// Интерфейс обработчика сценариев умного дома
public class ScenarioController {

    private static SmartHome smartHome;

    public ScenarioController(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    // Метод обработки сценария выключения всего света в доме
    public void runAllLightsOffScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof Light) {
                Light light = (Light) actionable;
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                System.out.println("Light " + light.getId() + " was turned off by HallDoor.");
                CommandSender.sendCommand(command);
            }
        });
    }
}