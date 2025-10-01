//  Main.java
public class Main {

    public static void main(String[] args) {
        try {
            // Example usage
            TransportService service1 = TransportFactory.getTransportService("bus");
            service1.bookTicket("Chennai", "Bangalore");

            TransportService service2 = TransportFactory.getTransportService("train");
            service2.bookTicket("Delhi", "Mumbai");

            TransportService service3 = TransportFactory.getTransportService("flight");
            service3.bookTicket("Kolkata", "Mumbai");

            // This will throw exception
            TransportService service4 = TransportFactory.getTransportService("bike");
            service4.bookTicket("Madurai", "Chennai");

        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }
}
