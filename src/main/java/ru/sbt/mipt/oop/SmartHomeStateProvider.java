package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeStateProvider {

    // считываем состояние дома
    SmartHome getHomeState() throws IOException;

}
