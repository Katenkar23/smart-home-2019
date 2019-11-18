package ru.sbt.mipt.oop.smarthome;

import java.io.IOException;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {

        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door("1", false)),
                "kitchen");
        Room bathroom = new Room(Arrays.asList(new Light("3", true)),
                Arrays.asList(new Door("2", false)),
                "bathroom");
        Room bedroom = new Room(Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door("3", true)),
                "bedroom");
        Room hall = new Room(Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)),
                Arrays.asList(new Door("4", false)),
                "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));
        JsonHomeWriter jsonExportProvider = new JsonHomeWriter("output.js", smartHome);
        jsonExportProvider.export();
    }
}
