package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.remotecontrol.RcHallLightOn;
import ru.sbt.mipt.oop.remotecontrol.RemoteControlImpl;
import ru.sbt.mipt.oop.smarthome.SmartHome;

import static org.junit.jupiter.api.Assertions.*;

class RemoteControlTest {

    RemoteControlImpl remoteControl;
    SmartHome smartHome;

    @BeforeEach
    void beginTests() {
        remoteControl = new RemoteControlImpl();
        smartHome = new SmartHome();
    }

    @Test
    void testAddCommand() {
        remoteControl.addCommand("A", new RcHallLightOn(smartHome));


    }

    @Test
    void testOnButtonPressed() {
    }
}