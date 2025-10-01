// TransportFactory.java
public class TransportFactory {
    public static TransportService getTransportService(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Transport type cannot be null or empty");
        }


        switch (type.toLowerCase()) {
            case "bus":
                return new BusService();
            case "train":
                return new TrainService();
            case "flight":
                return new FlightService();
            default:
                throw new UnsupportedOperationException("Transport type not supported: " + type);
        }
    }
}
