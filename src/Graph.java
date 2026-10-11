import java.util.*;

/**
 * Undirected graph using an adjacency list.
 * Supports add vertex, add edge, display, BFS and DFS.
 * BFS/DFS record steps and execution time for the performance comparison.
 */
public class Graph {

    private final Map<Integer, List<Integer>> adjList = new LinkedHashMap<>();

    // Last traversal metrics (used by PerformanceAnalyzer)
    private int lastBfsSteps = 0, lastDfsSteps = 0;
    private long lastBfsTimeNs = 0, lastDfsTimeNs = 0;

    public boolean isEmpty() {
        return adjList.isEmpty();
    }

    public boolean hasVertex(int v) {
        return adjList.containsKey(v);
    }

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(int v) {
        if (adjList.containsKey(v)) {
            return false;
        }
        adjList.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns a message describing the result. */
    public String addEdge(int from, int to) {
        if (!hasVertex(from) || !hasVertex(to)) {
            return "Error: Both vertices must exist first.";
        }
        if (from == to) {
            return "Error: Self-loops are not allowed.";
        }
        if (adjList.get(from).contains(to)) {
            return "Edge already exists.";
        }
        adjList.get(from).add(to);
        adjList.get(to).add(from);
        return "Edge added: " + from + " <-> " + to;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Adjacency List:");
        for (Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** BFS using a queue. Visits vertices level by level. */
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!hasVertex(start)) {
            System.out.println("Error: Start vertex not found.");
            return order;
        }
        int steps = 0;
        long begin = System.nanoTime();

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            steps++; // one vertex processed
            for (int neighbour : adjList.get(current)) {
                steps++; // one edge checked
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        lastBfsTimeNs = System.nanoTime() - begin;
        lastBfsSteps = steps;
        return order;
    }

    /** DFS using an explicit stack. Goes as deep as possible before backtracking. */
    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!hasVertex(start)) {
            System.out.println("Error: Start vertex not found.");
            return order;
        }
        int steps = 0;
        long begin = System.nanoTime();

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            order.add(current);
            steps++; // one vertex processed
            List<Integer> neighbours = adjList.get(current);
            // push in reverse so the first neighbour is visited first
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                steps++; // one edge checked
                if (!visited.contains(neighbours.get(i))) {
                    stack.push(neighbours.get(i));
                }
            }
        }

        lastDfsTimeNs = System.nanoTime() - begin;
        lastDfsSteps = steps;
        return order;
    }

    public int getLastBfsSteps() { return lastBfsSteps; }
    public int getLastDfsSteps() { return lastDfsSteps; }
    public long getLastBfsTimeNs() { return lastBfsTimeNs; }
    public long getLastDfsTimeNs() { return lastDfsTimeNs; }
}
