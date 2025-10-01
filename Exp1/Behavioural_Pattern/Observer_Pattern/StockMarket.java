// Concrete Subject
public class StockMarket extends StockSubject 
{
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double stockPrice) 
    {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    // Setting up new stock price
    public void setStockPrice(double newPrice) 
    {
        System.out.println("\nUpdating " + stockName + " price to $" + newPrice);
        this.stockPrice = newPrice;
        notifyObservers(stockName, stockPrice);
    }
}

