public class EncryptionDecorator extends TransactionDecorator {

    public EncryptionDecorator(Transaction transaction) {
        super(transaction);
    }

    @Override
    public void execute() {
        System.out.println("[EncryptionDecorator] Encrypting transaction payload...");
        super.execute();
    }
}

