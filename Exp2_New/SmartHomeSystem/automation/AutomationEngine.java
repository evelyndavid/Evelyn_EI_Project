package automation;

import devices.AbstractDevice;
import devices.SmartDevice;
import devices.Thermostat;
import java.util.*;

public class AutomationEngine {
    private List<Trigger> triggers = new ArrayList<>();

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
    }

    public void showTriggers() {
        System.out.println("Automated Triggers: " + triggers);
    }

public void execute(Map<Integer, SmartDevice> devices) {
    for (Trigger t : triggers) {
        if (t.getCondition().contains("temperature")) {
            String[] parts = t.getCondition().split(" ");
            int threshold = Integer.parseInt(parts[2]);

            for (SmartDevice device : devices.values()) {
                if (device instanceof Thermostat thermostat) {
                    if (thermostat.getTemperature() > threshold) {
                        System.out.println("Trigger activated: " + t);
                        String action = t.getAction();
                        if (action.startsWith("turnOff") || action.startsWith("turnOn")) {
                            int id = Integer.parseInt(action.replaceAll("[^0-9]", ""));
                            SmartDevice targetDevice = devices.get(id);

                            if (targetDevice == null) {
                                System.out.println("Device " + id + " not found. Action skipped.");
                                continue;
                            }

                            if (targetDevice instanceof AbstractDevice ad) {
                                if (action.startsWith("turnOn")) {
                                    if (ad.isDeviceOn()) {
                                        System.out.println("Device " + id + " is already ON.");
                                    } else {
                                        System.out.println(" Turning ON device " + id);
                                        ad.turnOn();
                                    }
                                } else if (action.startsWith("turnOff")) {
                                    if (!ad.isDeviceOn()) {
                                        System.out.println("Device " + id + " is already OFF.");
                                    } else {
                                        System.out.println(" Turning OFF device " + id);
                                        ad.turnOff();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


}
