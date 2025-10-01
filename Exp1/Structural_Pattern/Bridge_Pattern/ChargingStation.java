public class ChargingStation extends ChargingSession {

    public ChargingStation(ChargerVendor chargerVendor) {
        super(chargerVendor);
    }

    
    @Override
    public void begin(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            System.err.println("[ERROR] Invalid Vehicle ID.");
            return;
        }
        chargerVendor.startCharging(vehicleId);
    }

    @Override
    public void end(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            System.err.println("[ERROR] Invalid Vehicle ID.");
            return;
        }
        chargerVendor.stopCharging(vehicleId);
    }
}
