package tests;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.handlers.LightEventHandler;
import ru.sbt.mipt.oop.smarthome.Light;
import ru.sbt.mipt.oop.smarthome.Room;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.event.SensorEventType.*;

class LightEventHandlerTest {

    @Test
    public void testWorkHandlerFalse() {

        SmartHome smartHome = new SmartHome();

        String lightId = "1";

        Light light = new Light(lightId, false);

        smartHome.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "hall"));

        LightEventHandler lightHandler = new LightEventHandler(smartHome);

        SensorEvent event = new SensorEvent(LIGHT_ON, lightId);

        lightHandler.handle(event);

        event = new SensorEvent(LIGHT_OFF, lightId);

        lightHandler.handle(event);

        assertFalse(light.isOn());
    }

    @Test
    void testWorkHandlerTrue() {

        SmartHome smartHome = new SmartHome();

        String lightId = "1";

        Light light = new Light(lightId, false);

        smartHome.addRoom(new Room(Arrays.asList(light), Collections.emptyList(), "hall"));

        LightEventHandler lightHandler = new LightEventHandler(smartHome);

        SensorEvent event = new SensorEvent(LIGHT_OFF, lightId);

        lightHandler.handle(event);

        event = new SensorEvent(LIGHT_ON, lightId);

        lightHandler.handle(event);

        assertTrue(light.isOn());
    }
}