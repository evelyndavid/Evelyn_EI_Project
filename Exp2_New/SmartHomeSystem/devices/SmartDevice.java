package devices;

public interface SmartDevice {
    int getId();
    String getType();
    void turnOn();
    void turnOff();
    String getStatus();
}
