package ru.sbt.mipt.oop.scenarios;

import ru.sbt.mipt.oop.event.CommandType;
import ru.sbt.mipt.oop.event.SensorCommand;
import ru.sbt.mipt.oop.event.CommandSender;
import ru.sbt.mipt.oop.smarthome.Door;
import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import static ru.sbt.mipt.oop.event.SensorEventType.ALARM_ACTIVATE;

// Интерфейс обработчика сценариев умного дома
public class ScenarioController {

    private final SmartHome smartHome;

    public ScenarioController(SmartHome smartHome) {

        this.smartHome = smartHome;
    }

    // Метод обработки сценария включения всего света в доме
    public void runAllLightsOnScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof Light) {
                Light light = (Light) actionable;
                light.setOn(true);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_ON, light.getId());
                System.out.println("Light " + light.getId() + " was turned on by Scenario.");
                CommandSender.sendCommand(command);
            }
        });
    }

    // Метод обработки сценария выключения всего света в доме
    public void runAllLightsOffScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof Light) {
                Light light = (Light) actionable;
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                System.out.println("Light " + light.getId() + " was turned off by Scenario.");
                CommandSender.sendCommand(command);
            }
        });
    }

    // Метод обработки сценария закрытия входной двери
    public void runCloseHallDoorScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof Room) {
                Room room = (Room) actionable;
                if (room.getName().equals("hall")) {
                    room.execute(hallActionable -> {
                        if (hallActionable instanceof Door) {
                            Door door = (Door) hallActionable;
                            door.setOpen(false);
                            SensorCommand command = new SensorCommand(CommandType.DOOR_CLOSED, door.getId());
                            System.out.println("Door " + door.getId() + " was closed by Scenario.");
                            CommandSender.sendCommand(command);
                        }
                    });
                }
            }
        });
    }

    // Метод обработки сценария выключения света в коридоре
    public void runTurnOffHallLightScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof Room) {
                Room room = (Room) actionable;
                if (room.getName().equals("hall")) {
                    room.execute(hallActionable -> {
                        if (hallActionable instanceof Light) {
                            Light light = (Light) hallActionable;
                            light.setOn(false);
                            SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                            System.out.println("Light " + light.getId() + " was turned off by Scenario.");
                            CommandSender.sendCommand(command);
                        }
                    });
                }
            }
        });
    }

    // Метод обработки сценария активации сигнализации
    public void runAlarmActivateScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof AlarmSystem) {
                AlarmSystem alarm = (AlarmSystem) actionable;
                alarm.activate(ALARM_ACTIVATE.getCode());
                System.out.println("Alarm " + alarm.getId() + " activated by Scenario.");
            }
        });
    }

    // Метод обработки сценария активации тревоги
    public void runAlarmAlertScenario() {

        smartHome.execute(actionable -> {
            if (actionable instanceof AlarmSystem) {
                AlarmSystem alarm = (AlarmSystem) actionable;
                alarm.alert();
                System.out.println("Alarm " + alarm.getId() + " alerted by Scenario.");
            }
        });
    }
}