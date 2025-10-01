import java.util.Random;

public class FeeDecorator extends TransactionDecorator {

    public FeeDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void execute() {
        double fee = new Random().nextDouble() * 5; // random fee
        System.out.println("[FeeDecorator] Adding transaction fee: $" + String.format("%.2f", fee));
        super.execute();
    }
}


