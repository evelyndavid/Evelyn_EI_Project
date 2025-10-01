// Context class
public class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Strategy set: " + strategy.getClass().getSimpleName());
    }

    public void executeSort(int[] arr) {
        if (strategy != null) strategy.sort(arr);
        else System.out.println("No sorting strategy selected!");
    }
}

