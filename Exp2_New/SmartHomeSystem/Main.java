//NEW FORM 

import devices.*;
import hub.*;
import java.util.Scanner; // your logging utility package
import util.LoggingUtil;

public class Main {
    private static final SmartHomeHub hub = new SmartHomeHub();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         SMART HOME SYSTEM          ║");
        System.out.println("╚════════════════════════════════════╝");
        // Initialize default devices
        hub.addDevice(DeviceFactory.createDevice("light", 1));
        hub.addDevice(DeviceFactory.createDevice("thermostat", 2));
        hub.addDevice(DeviceFactory.createDevice("door", 3));

        while (true) {
            try {
                System.out.println("\nCommands: ");
                System.out.println("1) Status");
                System.out.println("2) TurnOn");
                System.out.println("3) TurnOff");
                System.out.println("4) Schedule");
                System.out.println("5) Triggers");
                System.out.println("6) Add Device");
                System.out.println("7) Remove Device");
                System.out.println("8) Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        if (hub.getAllDevices().isEmpty()) {
                            LoggingUtil.logWarn("No devices available to show status.");
                        } else {
                            hub.showStatus();
                        }
                    }

                    case 2 -> {
                        if (hub.getAllDevices().isEmpty()) {
                            LoggingUtil.logWarn("No devices available to operate.");
                            break;
                        }
                        LoggingUtil.logInfo("Enter device ID: ");
                        int id = scanner.nextInt();
                        SmartDevice device = hub.getDevice(id);
                        if (device == null) {
                            LoggingUtil.logError("Device not found!");
                        } else {
                            try {
                                if (device instanceof AbstractDevice ad && ad.isDeviceOn()) {
                                    LoggingUtil.logInfo("Device " + id + " is already ON.");
                                } else {
                                    new DeviceProxy(device).turnOn();
                                }
                            } catch (Exception e) {
                                LoggingUtil.logWarn("Error turning ON device " + id + ": " + e.getMessage());
                            }
                        }
                    }

                    case 3 -> {
                        if (hub.getAllDevices().isEmpty()) {
                            LoggingUtil.logWarn("No devices available to operate.");
                            break;
                        }
                        LoggingUtil.logInfo("Enter device ID: ");
                        int id = scanner.nextInt();
                        SmartDevice device = hub.getDevice(id);
                        if (device == null) {
                            LoggingUtil.logError("Device not found!");
                        } else {
                            try {
                                if (device instanceof AbstractDevice ad && !ad.isDeviceOn()) {
                                    LoggingUtil.logInfo("Device " + id + " is already OFF.");
                                } else {
                                    new DeviceProxy(device).turnOff();
                                }
                            } catch (Exception e) {
                                LoggingUtil.logWarn("Error turning OFF device " + id + ": " + e.getMessage());
                            }
                        }
                    }

                    case 4 -> {
                        if (hub.getAllDevices().isEmpty()) {
                            LoggingUtil.logWarn("No devices available for scheduling.");
                            break;
                        }
                        LoggingUtil.logInfo("Enter device ID, time, command: ");
                        int id = scanner.nextInt();
                        String time = scanner.next();
                        String command = scanner.next();
                        hub.schedule(id, time, command);
                        hub.showSchedules();
                    }

                    case 5 -> {
                        if (hub.getAllDevices().isEmpty()) {
                        LoggingUtil.logWarn("No devices available for triggers.");
                         break;
                    }

                    scanner.nextLine(); 

                    
                    System.out.println("Enter trigger condition (e.g., temperature > 25): ");
                    String condition = scanner.nextLine();

                    System.out.println("Enter trigger action (e.g., turnOff(1) ): ");
                    String action = scanner.nextLine();

                    
                    hub.addTrigger(condition, action);
                    LoggingUtil.logInfo("Trigger added successfully!");

                    
                    hub.showTriggers();

                    
                    hub.checkTriggers();
                }


                    

                    case 6 -> {
                        LoggingUtil.logInfo("Enter new device type (light/thermostat/door): ");
                        String type = scanner.next();
                        LoggingUtil.logInfo("Enter new device ID: ");
                        int id = scanner.nextInt();

                        if (hub.getDevice(id) != null) {
                            LoggingUtil.logError("Device ID already exists! Try again with a different ID.");
                        } else {
                            try {
                                hub.addDevice(DeviceFactory.createDevice(type, id));
                            } catch (IllegalArgumentException e) {
                                LoggingUtil.logError("Invalid device type!");
                            }
                        }
                    }

                    case 7 -> {
                        if (hub.getAllDevices().isEmpty()) {
                            LoggingUtil.logWarn("No devices available to remove.");
                            break;
                        }
                        LoggingUtil.logInfo("Enter device ID to remove: ");
                        int id = scanner.nextInt();
                        if (hub.getDevice(id) == null) {
                            LoggingUtil.logError("Device with ID " + id + " is not available!");
                        } else {
                            hub.removeDevice(id);
                        }
                    }

                    case 8 -> {
                        LoggingUtil.logInfo("Exiting system...");
                        System.exit(0);
                    }
                    default -> LoggingUtil.logWarn("Invalid choice! Try again.");
                }

            } catch (Exception e) {
                LoggingUtil.logWarn("Something went wrong: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
}
