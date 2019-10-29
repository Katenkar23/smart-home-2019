package ru.sbt.mipt.oop.scenarios;

import ru.sbt.mipt.oop.event.CommandType;
import ru.sbt.mipt.oop.event.SensorCommand;
import ru.sbt.mipt.oop.event.controllers.HomeCommandController;
import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;

// Интерфейс обработчика сценариев умного дома
public class ScenarioController {

    private static SmartHome smartHome;

    public ScenarioController(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    // Метод обработки сценария закрытия входной двери холла
    public void runCloseHallDoorScenario() {
        runAllLightsOffScenario();
    }

    // Метод обработки сценария выключения всего света в доме
    public void runAllLightsOffScenario() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                HomeCommandController.sendCommand(command);
            }
        }
    }
}
