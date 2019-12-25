package ru.sbt.mipt.oop.event.handlers;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;
import ru.sbt.mipt.oop.event.manager.EventHandler;
import ru.sbt.mipt.oop.smarthome.alarm.AlarmSystem;
import ru.sbt.mipt.oop.event.eventtypechooser.*;

import java.util.Collection;

public class CCEventHandlerAdapter implements EventHandler {

    private final AlarmSystemDecorator decorator;
    private final EventTypeChooser chooser;

    public CCEventHandlerAdapter(Collection<SensorEventHandler> handlers, EventTypeChooser chooser, AlarmSystem alarm) {
        decorator = new AlarmSystemDecorator(handlers, alarm);
        this.chooser = chooser;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        SensorEvent sensorEvent = adaptSensorEvent(event);

        if (sensorEvent != null) {
            decorator.handle(sensorEvent);
        }
    }

    private SensorEvent adaptSensorEvent(CCSensorEvent event) {
        return chooser.adaptEvent(event);
    }

}
