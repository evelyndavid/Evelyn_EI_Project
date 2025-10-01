//  BusService.java
public class BusService implements TransportService {
    @Override
    public void bookTicket(String source, String destination) {
        System.out.println("[BusService] Booking bus ticket from " + source + " to " + destination);
    }
}

