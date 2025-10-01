public class GenericCharger implements ChargerVendor {
    @Override
    public void startCharging(String vehicleId) {
        System.out.println("[GenericCharger] Starting standard charging for vehicle " + vehicleId);
    }

    @Override
    public void stopCharging(String vehicleId) {
        System.out.println("[GenericCharger] Stopping charging for vehicle " + vehicleId);
    }
}

