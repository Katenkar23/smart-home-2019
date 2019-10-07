package ru.sbt.mipt.oop;

public class JsonSmartHomeStateProvider implements SmartHomeStateProvider {

    private String fileName;

    public JsonSmartHomeStateProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void getState() {

    }
}
