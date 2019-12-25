package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;
import ru.sbt.mipt.oop.event.adapt.*;

import java.util.Collection;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

public class CCEventHandlerAdapter implements EventHandler {

    private final AlarmSystemDecorator decorator;

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers, AlarmSystem alarm) {
        decorator = new AlarmSystemDecorator(handlers, alarm);
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);

        if (sensorEvent != null) {
            decorator.handle(sensorEvent);
        }
    }

    private SensorEvent adaptSensorEvent(CCSensorEvent event) {
        return new LightOnTypeChooser(new LightOffTypeChooser(new DoorOpenTypeChooser(new DoorClosedTypeChooser(new EmptyTypeChooser())))).adaptEvent(event);
    }

}
