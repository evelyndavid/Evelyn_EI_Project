// Concrete Observer
public class StockObserver implements Observer 
{
    private String investorName;

    public StockObserver(String investorName) 
    {
        this.investorName = investorName;
    }

    @Override
    public void update(String stockName, double price) 
    {
        System.out.println("Notification for " + investorName + ": "
                + stockName + " price changed to $" + price);
    }

    @Override
    public String toString() {
        return "Investor {" + investorName + "}";
    }
}

