public abstract class ChargingSession {
    protected ChargerVendor chargerVendor;

    public ChargingSession(ChargerVendor chargerVendor) {
        this.chargerVendor = chargerVendor;
    }

    public abstract void begin(String vehicleId);
    public abstract void end(String vehicleId);
}

