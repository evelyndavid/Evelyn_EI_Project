public class TeslaCharger implements ChargerVendor {
    @Override
    public void startCharging(String vehicleId) {
        System.out.println("[TeslaCharger] Starting super-fast charging for vehicle " + vehicleId);
    }

    @Override
    public void stopCharging(String vehicleId) {
        System.out.println("[TeslaCharger] Stopping charging for vehicle " + vehicleId);
    }
}

