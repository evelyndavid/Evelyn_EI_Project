package devices;

public abstract class AbstractDevice implements SmartDevice {
    protected int id;
    protected String type;
    protected boolean isOn;

    public AbstractDevice(int id, String type) {
        this.id = id;
        this.type = type;
        this.isOn = false;
    }

    public int getId() { return id; }
    public String getType() { return type; }

    @Override
    public void turnOn() { isOn = true; }

    @Override
    public void turnOff() { isOn = false; }

    @Override
    public String getStatus() {
        return type + " " + id + " is " + (isOn ? "On" : "Off");
    }

    // TO GET THE STATE  OF THE DEVICE
    public String getDeviceState() {
        return isOn ? "On" : "Off";
    }

    public boolean isDeviceOn() {
        return isOn;
    }

}
