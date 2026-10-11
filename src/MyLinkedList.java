/**
 * Singly linked list with insert, delete, search and display.
 */
public class MyLinkedList {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size = 0;

    public boolean isEmpty() { return head == null; }

    /** O(1) */
    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    /** O(n) because we walk to the tail. */
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        size++;
    }

    /** Deletes first node holding the value. O(n). */
    public boolean delete(int value) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node cur = head;
        while (cur.next != null && cur.next.data != value) {
            cur = cur.next;
        }
        if (cur.next == null) {
            System.out.println("Value " + value + " not found.");
            return false;
        }
        cur.next = cur.next.next;
        size--;
        return true;
    }

    /** Returns position (0-based) or -1. O(n). */
    public int search(int value) {
        int pos = 0;
        for (Node cur = head; cur != null; cur = cur.next, pos++) {
            if (cur.data == value) {
                return pos;
            }
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Linked List: ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        System.out.println(sb + "null  [size " + size + "]");
    }
}
