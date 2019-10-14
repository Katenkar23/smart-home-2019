package ru.sbt.mipt.oop;

// Интерфейс обработчика сценариев умного дома
public interface ScenarioDriver {

    // Метод обработки сценария закрытия входной двери холла
    void runCloseHallDoorScenario();

    // Метод обработки сценария выключения всего света в доме
    void runAllLightsOffScenario();
}
