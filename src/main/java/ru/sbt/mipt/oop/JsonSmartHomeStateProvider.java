package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSmartHomeStateProvider implements SmartHomeStateProvider {

    private String fileName;

    public JsonSmartHomeStateProvider(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SmartHome getHomeState() {

        SmartHome smartH = new SmartHome();

        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(Paths.get(fileName)));
            smartH = gson.fromJson(json, SmartHome.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return smartH;
    }
}
