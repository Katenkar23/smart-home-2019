package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.Setup;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventType;
import ru.sbt.mipt.oop.event.handlers.AlarmSystemDecorator;
import ru.sbt.mipt.oop.event.handlers.AlarmSystemEventHandler;
import ru.sbt.mipt.oop.event.handlers.DoorEventHandler;
import ru.sbt.mipt.oop.event.handlers.SensorEventHandler;
import ru.sbt.mipt.oop.smarthome.SmartHome;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmActivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmAlert;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import java.beans.EventHandler;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.event.SensorEventType.*;

class AlarmSystemEventHandlerTest {

    private SmartHome smartHome;
    private AlarmSystem alarm;
    private final String RIGHT_CODE = "XXX";
    private final String WRONG_CODE = "xXx";

    @BeforeEach
    void beginTests() {
        smartHome = new SmartHome();
        alarm = smartHome.getAlarm();
    }

    @Test
    public void testWorkHandlerActivated() {

        SensorEvent event = new SensorEvent(ALARM_ACTIVATE, alarm.getId());

        AlarmSystemEventHandler alarmHandler = new AlarmSystemEventHandler(smartHome);

        alarmHandler.handle(event);

        assertTrue(alarm.getAlarmState() instanceof AlarmActivated);
    }

    @Test
    public void testWorkHandlerTrue() {

        SensorEvent event = new SensorEvent(ALARM_DEACTIVATE, alarm.getId());

        AlarmSystemEventHandler alarmHandler = new AlarmSystemEventHandler(smartHome);

        alarmHandler.handle(event);

        assertTrue(alarm.getAlarmState() instanceof AlarmDeactivated);
    }

    @Test
    public void testWorkDecorator() {
        SensorEvent event = new SensorEvent(DOOR_CLOSED, alarm.getId());

        AlarmSystemDecorator decorator = new AlarmSystemDecorator(new Setup(smartHome).getHandlers(), alarm);

        alarm.activate(ALARM_ACTIVATE.getCode());
        decorator.handle(event);

        assertTrue(alarm.getAlarmState() instanceof AlarmAlert);
    }
}