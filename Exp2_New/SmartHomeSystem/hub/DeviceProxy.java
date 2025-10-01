package hub;

import devices.SmartDevice;

public class DeviceProxy implements SmartDevice {
    private SmartDevice realDevice;

    public DeviceProxy(SmartDevice realDevice) {
        this.realDevice = realDevice;
    }

    @Override
    public int getId() { return realDevice.getId(); }

    @Override
    public String getType() { return realDevice.getType(); }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Access granted to turn ON device.");
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Access granted to turn OFF device.");
        realDevice.turnOff();
    }

    @Override
    public String getStatus() { return realDevice.getStatus(); }
}
