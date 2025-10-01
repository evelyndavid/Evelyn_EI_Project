public class TataCharger implements ChargerVendor {
    @Override
    public void startCharging(String vehicleId) {
        System.out.println("[TataCharger] Starting eco-mode charging for vehicle " + vehicleId);
    }

    @Override
    public void stopCharging(String vehicleId) {
        System.out.println("[TataCharger] Stopping charging for vehicle " + vehicleId);
    }
}

