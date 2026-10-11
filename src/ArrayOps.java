/**
 * Fixed-capacity array with insert, delete, search and display operations.
 */
public class ArrayOps {

    private final int[] data;
    private int size = 0;

    public ArrayOps(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public int getSize() { return size; }

    /** Inserts at the end. O(1). */
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Array is full (capacity " + data.length + ").");
            return false;
        }
        data[size++] = value;
        return true;
    }

    /** Inserts at a given index, shifting elements right. O(n). */
    public boolean insertAt(int index, int value) {
        if (isFull()) {
            System.out.println("Array is full (capacity " + data.length + ").");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index. Valid range: 0 to " + size);
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Deletes the first occurrence of a value, shifting elements left. O(n). */
    public boolean deleteValue(int value) {
        if (isEmpty()) {
            System.out.println("Array is empty. Nothing to delete.");
            return false;
        }
        int idx = search(value);
        if (idx == -1) {
            System.out.println("Value " + value + " not found.");
            return false;
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Linear search. Returns index or -1. O(n). */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Array [size " + size + "/" + data.length + "]: ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(i < size - 1 ? ", " : "");
        }
        System.out.println(sb);
    }
}
