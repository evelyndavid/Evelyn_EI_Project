public class NotificationDecorator extends TransactionDecorator {

    public NotificationDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("[NotificationDecorator] Notifying user: Transaction completed!");
    }
}

