/**
 * Stack (LIFO) implemented with a fixed-size array.
 */
public class MyStack {

    private final int[] items;
    private int top = -1;

    public MyStack(int capacity) {
        items = new int[capacity];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == items.length - 1; }

    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow! Stack is full.");
            return false;
        }
        items[++top] = value;
        return true;
    }

    /** Returns popped value, or null if the stack is empty. */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Stack is empty.");
            return null;
        }
        return items[top--];
    }

    /** Returns top value without removing it, or null if empty. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top first):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
