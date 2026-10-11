/**
 * Queue (FIFO) implemented with linked nodes. Enqueue and dequeue are both O(1).
 */
public class MyQueue {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front, rear;
    private int size = 0;

    public boolean isEmpty() { return front == null; }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    /** Returns removed value, or null if the queue is empty. */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Queue is empty.");
            return null;
        }
        int value = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    /** Returns front value without removing it, or null if empty. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing at front.");
            return null;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Queue (front -> rear): ");
        for (Node n = front; n != null; n = n.next) {
            sb.append(n.data).append(n.next != null ? " -> " : "");
        }
        System.out.println(sb + "  [size " + size + "]");
    }
}
