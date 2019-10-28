package ru.sbt.mipt.oop;

public interface HomeCommandController {

    void action(SensorCommand command);

    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}
