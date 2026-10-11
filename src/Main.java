import java.util.*;

/**
 * Entry point. Shows the main menu and routes to each component's submenu.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayOps array = new ArrayOps(20);
    private static final MyStack stack = new MyStack(20);
    private static final MyQueue queue = new MyQueue();
    private static final MyLinkedList list = new MyLinkedList();
    private static final SearchOps search = new SearchOps();
    private static final Graph graph = new Graph();

    // Stores text results for "Display All Results"
    private static final List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchMenu(); break;
                case 6: graphMenu(); break;
                case 7: PerformanceAnalyzer.run(graph, results); break;
                case 8: displayAllResults(); break;
                case 9:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-9.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------------- ARRAY ----------------

    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete by Value");
            System.out.println("4. Search (Linear)");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int v = readInt("Value to insert: ");
                    if (array.insert(v)) System.out.println("Inserted " + v);
                    break;
                case 2:
                    int idx = readInt("Index: ");
                    int val = readInt("Value: ");
                    if (array.insertAt(idx, val)) System.out.println("Inserted " + val + " at index " + idx);
                    break;
                case 3:
                    int d = readInt("Value to delete: ");
                    if (array.deleteValue(d)) System.out.println("Deleted " + d);
                    break;
                case 4:
                    int s = readInt("Value to search: ");
                    int found = array.search(s);
                    System.out.println(found == -1 ? "Not found." : "Found at index " + found);
                    break;
                case 5: array.display(); break;
                case 6: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-6.");
            }
        }
    }

    // ---------------- STACK ----------------

    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int v = readInt("Value to push: ");
                    if (stack.push(v)) System.out.println("Pushed " + v);
                    break;
                case 2:
                    Integer popped = stack.pop();
                    if (popped != null) System.out.println("Popped " + popped);
                    break;
                case 3:
                    Integer top = stack.peek();
                    if (top != null) System.out.println("Top element: " + top);
                    break;
                case 4: stack.display(); break;
                case 5: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-5.");
            }
        }
    }

    // ---------------- QUEUE ----------------

    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int v = readInt("Value to enqueue: ");
                    queue.enqueue(v);
                    System.out.println("Enqueued " + v);
                    break;
                case 2:
                    Integer removed = queue.dequeue();
                    if (removed != null) System.out.println("Dequeued " + removed);
                    break;
                case 3:
                    Integer front = queue.peek();
                    if (front != null) System.out.println("Front element: " + front);
                    break;
                case 4: queue.display(); break;
                case 5: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-5.");
            }
        }
    }

    // ---------------- LINKED LIST ----------------

    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n----------- LINKED LIST OPERATIONS ----------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete by Value");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int a = readInt("Value: ");
                    list.insertAtBeginning(a);
                    System.out.println("Inserted " + a + " at beginning.");
                    break;
                case 2:
                    int b = readInt("Value: ");
                    list.insertAtEnd(b);
                    System.out.println("Inserted " + b + " at end.");
                    break;
                case 3:
                    int d = readInt("Value to delete: ");
                    if (list.delete(d)) System.out.println("Deleted " + d);
                    break;
                case 4:
                    int s = readInt("Value to search: ");
                    int pos = list.search(s);
                    System.out.println(pos == -1 ? "Not found." : "Found at position " + pos);
                    break;
                case 5: list.display(); break;
                case 6: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-6.");
            }
        }
    }

    // ---------------- SEARCHING ----------------

    private static void searchMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------- SEARCHING OPERATIONS ----------");
            System.out.println("1. Generate Random Sorted Array");
            System.out.println("2. Enter Array Manually");
            System.out.println("3. Display Array");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Compare Linear vs Binary");
            System.out.println("7. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int n = readInt("Array size (1 - 1000000): ");
                    if (n < 1 || n > 1000000) {
                        System.out.println("Size out of range.");
                    } else {
                        search.generateRandom(n);
                        System.out.println("Generated and sorted " + n + " elements.");
                    }
                    break;
                case 2: enterArrayManually(); break;
                case 3: search.display(); break;
                case 4:
                    if (needData()) {
                        int t = readInt("Target: ");
                        report("Linear Search", t, search.linearSearch(t));
                    }
                    break;
                case 5:
                    if (needData()) {
                        int t = readInt("Target: ");
                        report("Binary Search", t, search.binarySearch(t));
                    }
                    break;
                case 6:
                    if (needData()) {
                        int t = readInt("Target: ");
                        report("Linear Search", t, search.linearSearch(t));
                        report("Binary Search", t, search.binarySearch(t));
                    }
                    break;
                case 7: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-7.");
            }
        }
    }

    private static boolean needData() {
        if (search.isEmpty()) {
            System.out.println("No data. Generate or enter an array first.");
            return false;
        }
        return true;
    }

    private static void enterArrayManually() {
        System.out.print("Enter numbers separated by spaces or commas: ");
        String[] parts = scanner.nextLine().trim().split("[,\\s]+");
        try {
            int[] values = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                values[i] = Integer.parseInt(parts[i]);
            }
            search.setData(values);
            System.out.println("Stored and sorted " + values.length + " elements.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Only whole numbers are allowed.");
        }
    }

    private static void report(String algo, int target, SearchOps.Result r) {
        String text = algo + " for " + target + ": "
                + (r.index == -1 ? "not found" : "found at index " + r.index)
                + " | Steps: " + r.steps + " | Time: " + r.timeNs + " ns";
        System.out.println(text);
        results.add(text);
    }

    // ---------------- GRAPH ----------------

    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            switch (readInt("Enter your choice: ")) {
                case 1:
                    int v = readInt("Enter vertex number: ");
                    System.out.println(graph.addVertex(v) ? "Vertex " + v + " added." : "Vertex already exists.");
                    break;
                case 2:
                    if (graph.isEmpty()) {
                        System.out.println("Add vertices first.");
                        break;
                    }
                    int from = readInt("From vertex: ");
                    int to = readInt("To vertex: ");
                    System.out.println(graph.addEdge(from, to));
                    break;
                case 3: graph.display(); break;
                case 4:
                    if (graph.isEmpty()) {
                        System.out.println("Graph is empty.");
                        break;
                    }
                    int bStart = readInt("Start vertex: ");
                    List<Integer> bfsOrder = graph.bfs(bStart);
                    if (!bfsOrder.isEmpty()) {
                        String r = "BFS from " + bStart + ": " + bfsOrder
                                + " | Steps: " + graph.getLastBfsSteps()
                                + " | Time: " + graph.getLastBfsTimeNs() + " ns";
                        System.out.println(r);
                        results.add(r);
                    }
                    break;
                case 5:
                    if (graph.isEmpty()) {
                        System.out.println("Graph is empty.");
                        break;
                    }
                    int dStart = readInt("Start vertex: ");
                    List<Integer> dfsOrder = graph.dfs(dStart);
                    if (!dfsOrder.isEmpty()) {
                        String r = "DFS from " + dStart + ": " + dfsOrder
                                + " | Steps: " + graph.getLastDfsSteps()
                                + " | Time: " + graph.getLastDfsTimeNs() + " ns";
                        System.out.println(r);
                        results.add(r);
                    }
                    break;
                case 6: back = true; break;
                default: System.out.println("Invalid choice. Please enter 1-6.");
            }
        }
    }

    // ---------------- RESULTS ----------------

    private static void displayAllResults() {
        System.out.println("\n--------------- ALL RESULTS ---------------");
        if (results.isEmpty()) {
            System.out.println("No results recorded yet.");
            return;
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
    }

    // ---------------- INPUT VALIDATION ----------------

    /** Keeps asking until the user enters a valid integer. */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                System.exit(0); // input closed
            }
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}
