package ru.sbt.mipt.oop.event.eventtypechooser;

import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.manager.CCSensorEvent;

//"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"

public interface EventTypeChooser {
    SensorEvent adaptEvent(CCSensorEvent ccEvent);
}
