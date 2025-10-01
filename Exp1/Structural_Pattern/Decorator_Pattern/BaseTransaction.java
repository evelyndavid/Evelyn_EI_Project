public class BaseTransaction implements Transaction {
    private String payload;

    public BaseTransaction(String payload) {
        this.payload = payload;
    }

    @Override
    public void execute() {
        System.out.println("[BaseTransaction] Executing transaction with payload: " + payload);
    }
}

