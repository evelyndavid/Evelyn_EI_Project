import java.util.ArrayList;
import java.util.List;


public class StockSubject 
{
    private List<Observer> observers = new ArrayList<>();

    // Adding an observer
    public void addObserver(Observer observer) 
    {
        observers.add(observer);
        System.out.println("Observer added: " + observer);
    }

    // Removing an observer
    public void removeObserver(Observer observer) 
    {
        observers.remove(observer);
        System.out.println("Observer removed: " + observer);
    }

    // Notifying all observers
    public void notifyObservers(String stockName, double price) 
    {
        for (Observer observer : observers) 
        {
            observer.update(stockName, price);
        }
    }
}

