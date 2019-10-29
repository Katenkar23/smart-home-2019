package ru.sbt.mipt.oop.event;

public class SensorCommand {
    private CommandType type;
    private final String objectId;

    public SensorCommand(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorCommand(SensorEvent event) {
        switch (event.getType()) {
            case LIGHT_ON : this.type = CommandType.LIGHT_ON;
            case LIGHT_OFF : this.type = CommandType.LIGHT_OFF;
            case DOOR_OPEN : this.type = CommandType.DOOR_OPEN;
            case DOOR_CLOSED : this.type = CommandType.DOOR_CLOSED;
            default : this.type = CommandType.LIGHT_OFF;
        }

        this.objectId = event.getObjectId();
    }

    public CommandType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorCommand{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
