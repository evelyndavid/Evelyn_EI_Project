package devices;

public class DeviceFactory {
    public static SmartDevice createDevice(String type, int id) {
        return switch (type.toLowerCase()) {
            case "light" -> new Light(id);
            case "thermostat" -> new Thermostat(id, 22);
            case "door" -> new DoorLock(id);
            default -> throw new IllegalArgumentException("Unknown device type: " + type);
        };
    }
}
