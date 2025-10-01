// Main driver class
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 8, 2, 1};
        int[] arr2 = {12, 7, 9, 21, 5};
        int[] arr3 = {34, 2, 10, 6, 7};

        SortContext context = new SortContext();

        // Bubble Sort
        context.setStrategy(new BubbleSort());
        context.executeSort(arr1);

        // Quick Sort
        context.setStrategy(new QuickSort());
        context.executeSort(arr2);

        // Merge Sort
        context.setStrategy(new MergeSort());
        context.executeSort(arr3);
    }
}

