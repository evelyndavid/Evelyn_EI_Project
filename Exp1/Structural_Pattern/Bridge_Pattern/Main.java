public class Main {
    public static void main(String[] args) {
        try {
            // 3 different EV vehicles
            simulateCharging(new TeslaCharger(), "TESLA-123");
            simulateCharging(new TataCharger(), "TATA-456");
            simulateCharging(new GenericCharger(), "GEN-789");

            
            System.out.println("\nAll charging sessions completed successfully.");
        } catch (Exception e) {
            System.err.println("[EXCEPTION] Something went wrong: " + e.getMessage());
        }
    }

    private static void simulateCharging(ChargerVendor vendor, String vehicleId) {
        ChargingStation station = new ChargingStation(vendor);
        station.begin(vehicleId);
        System.out.println("   charging   ");
        station.end(vehicleId);
        System.out.println();
    }
}
