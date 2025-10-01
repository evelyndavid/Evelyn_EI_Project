
public class Main 
{
    public static void main(String[] args) {
        // Create stock market subject
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        // Create observers => investors
        Observer investor1 = new StockObserver("John");
        Observer investor2 = new StockObserver("Sam");
        Observer investor3 = new StockObserver("Jim");

        // Adding observers
        appleStock.addObserver(investor1);
        appleStock.addObserver(investor2);
        appleStock.addObserver(investor3);

        // Updating the stock prices
        appleStock.setStockPrice(152.35);
        appleStock.setStockPrice(148.90);

        // Removing an observer
        appleStock.removeObserver(investor2);

        // Updating the stock price again
        appleStock.setStockPrice(155.50);
    }
}