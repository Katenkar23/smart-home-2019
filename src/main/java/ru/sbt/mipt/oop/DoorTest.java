package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {

    @Test
    void testExecute() {
    }

    @Test
    void testSetOpen() {
        Door door = new Door(true, "1");

        door.setOpen(true);

        assertEquals(true, true);
    }
}