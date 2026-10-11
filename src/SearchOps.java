import java.util.*;

/**
 * Linear and Binary search on a sorted int array, with step counting and timing.
 * The stored array is always kept sorted so that binary search is valid.
 */
public class SearchOps {

    /** Holds the outcome of one search. */
    public static class Result {
        public final int index;
        public final int steps;
        public final long timeNs;

        Result(int index, int steps, long timeNs) {
            this.index = index;
            this.steps = steps;
            this.timeNs = timeNs;
        }
    }

    private int[] data = new int[0];

    public boolean isEmpty() { return data.length == 0; }

    /** Random values, then sorted. */
    public void generateRandom(int n) {
        Random rnd = new Random();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = rnd.nextInt(n * 10);
        }
        Arrays.sort(data);
    }

    /** Values 0, 2, 4, ... (no duplicates) - used for fair performance tests. */
    public void generateSequential(int n) {
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i * 2;
        }
    }

    public void setData(int[] values) {
        data = values.clone();
        Arrays.sort(data);
    }

    public int[] getData() { return data; }

    public void display() {
        if (isEmpty()) {
            System.out.println("No data. Generate or enter an array first.");
            return;
        }
        if (data.length > 50) {
            System.out.println("Sorted array of " + data.length + " elements (first 50): "
                    + Arrays.toString(Arrays.copyOf(data, 50)) + " ...");
        } else {
            System.out.println("Sorted array: " + Arrays.toString(data));
        }
    }

    /** O(n): checks elements one by one. */
    public Result linearSearch(int target) {
        int steps = 0;
        int found = -1;
        long start = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            steps++;
            if (data[i] == target) {
                found = i;
                break;
            }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }

    /** O(log n): halves the search range each step. Needs sorted data. */
    public Result binarySearch(int target) {
        int steps = 0;
        int found = -1;
        int low = 0, high = data.length - 1;
        long start = System.nanoTime();
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (data[mid] == target) {
                found = mid;
                break;
            } else if (data[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new Result(found, steps, System.nanoTime() - start);
    }
}
