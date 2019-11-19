package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmActivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmAlert;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmDeactivated;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;

import static org.junit.jupiter.api.Assertions.*;

class AlarmSystemTest {

    private AlarmSystem alarm;
    private final String RIGHT_CODE = "XXX";
    private final String WRONG_CODE = "xXx";

    @BeforeEach
    void beginTests() {
        alarm = new AlarmSystem("1", RIGHT_CODE);
    }

    @Test
    void testVerifyCodeFalse() {
        alarm.setCode(RIGHT_CODE);
        assertFalse(alarm.verifyCode(WRONG_CODE));
    }

    @Test
    void testVerifyCodeTrue() {
        alarm.setCode(RIGHT_CODE);
        assertTrue(alarm.verifyCode(RIGHT_CODE));
    }

    @Test
    void testActivate() {
        alarm.activate(RIGHT_CODE);
        assertTrue(alarm.getAlarmState() instanceof AlarmActivated);
    }

    @Test
    void testDeactivateActivatedTrue() {
        alarm.activate(RIGHT_CODE);
        alarm.deactivate(RIGHT_CODE);
        assertTrue(alarm.getAlarmState() instanceof AlarmDeactivated);
    }

    @Test
    void testDeactivateActivatedFalse() {
        alarm.activate(RIGHT_CODE);
        alarm.deactivate(WRONG_CODE);
        assertTrue(alarm.getAlarmState() instanceof AlarmAlert);
    }

    @Test
    void testAlert() {
        alarm.alert();
        assertTrue(alarm.getAlarmState() instanceof AlarmAlert);
    }

    @Test
    void testDeactivateAlertTrue() {
        alarm.alert();
        alarm.deactivate(RIGHT_CODE);
        assertTrue(alarm.getAlarmState() instanceof AlarmDeactivated);
    }

    @Test
    void testDeactivateAlertFalse() {
        alarm.alert();
        alarm.deactivate(WRONG_CODE);
        assertTrue(alarm.getAlarmState() instanceof AlarmAlert);
    }
}