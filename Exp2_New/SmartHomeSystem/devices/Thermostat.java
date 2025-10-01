package devices;

public class Thermostat extends AbstractDevice {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "Thermostat");
        this.temperature = temperature;
        this.isOn = true; // thermostat usually is on running state from start
    }

    public void setTemperature(int temp) { this.temperature = temp; }
    public int getTemperature() { return temperature; }

    @Override
    public String getStatus() {
        return type + " " + id + " is set to " + temperature + "°C";
    }
}
