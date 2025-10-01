public abstract class TransactionDecorator implements Transaction {
    protected Transaction wrappedTransaction;

    public TransactionDecorator(Transaction transaction) {
        this.wrappedTransaction = transaction;
    }

    @Override
    public void execute() {
        wrappedTransaction.execute();
    }
}

