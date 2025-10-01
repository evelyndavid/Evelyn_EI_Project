// FlightService.java
public class FlightService implements TransportService {
    @Override
    public void bookTicket(String source, String destination) {
        System.out.println("[FlightService] Booking flight ticket from " + source + " to " + destination);
    }
}

