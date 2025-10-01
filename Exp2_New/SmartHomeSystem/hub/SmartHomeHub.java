package hub;

import automation.AutomationEngine;
import devices.SmartDevice;
import java.util.*;
import scheduler.Scheduler;

public class SmartHomeHub {
    private Map<Integer, SmartDevice> devices = new HashMap<>();
    private Scheduler scheduler = new Scheduler();
    private AutomationEngine automation = new AutomationEngine();

    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
        System.out.println("Added " + device.getType() + " with ID " + device.getId());
    }

    public void removeDevice(int id) 
    {
        
        devices.remove(id);
        System.out.println("Removed device with ID " + id);
    }

    public SmartDevice getDevice(int id) {
        return devices.get(id);
    }

     public Collection<SmartDevice> getAllDevices() {
        return devices.values();
    }

    public void showStatus() {
        if (devices.isEmpty()) {
            System.out.println("No devices found in the hub.");
        } else {
            for (SmartDevice d : devices.values()) {
                System.out.println("Device " + d.getId() + " (" + d.getType() + ")  " + d.getStatus());
            }
        }
    }

    public void schedule(int deviceId, String time, String command) {
        scheduler.addTask(deviceId, time, command);
    }

    public void showSchedules() { scheduler.showTasks(); }

    public void addTrigger(String condition, String action) {
        automation.addTrigger(condition, action);
    }

    public void showTriggers() { automation.showTriggers(); }

    public void checkTriggers() {
        automation.execute(devices);
    }
}
