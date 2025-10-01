public class AnalyticsDecorator extends TransactionDecorator {

    public AnalyticsDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("[AnalyticsDecorator] Recording transaction metrics for analytics.");
    }
}
