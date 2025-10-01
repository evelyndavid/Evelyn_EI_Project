//  TrainService.java
public class TrainService implements TransportService {
    @Override
    public void bookTicket(String source, String destination) {
        System.out.println("[TrainService] Booking train ticket from " + source + " to " + destination);
    }
}

