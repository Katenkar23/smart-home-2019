package ru.sbt.mipt.oop.event;

public class SensorCommand {
    private CommandType type;
    private final String objectId;

    public SensorCommand(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
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
