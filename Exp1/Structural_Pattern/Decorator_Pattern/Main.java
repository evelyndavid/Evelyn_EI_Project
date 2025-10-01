public class Main {
    public static void main(String[] args) {
        // Base transaction
        Transaction tx = new BaseTransaction("Send 10 BTC to Alice");

        // Decorate transaction dynamically
        Transaction decoratedTx = new FeeDecorator(
                                    new EncryptionDecorator(
                                    new NotificationDecorator(
                                    new AnalyticsDecorator(tx))));

        // Execute transaction
        decoratedTx.execute();
    }
}

