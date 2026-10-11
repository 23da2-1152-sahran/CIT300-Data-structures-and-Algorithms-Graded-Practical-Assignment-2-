import java.util.List;

/**
 * Builds the performance comparison table:
 * Linear vs Binary search on growing array sizes, and BFS vs DFS on the user's graph.
 */
public class PerformanceAnalyzer {

    public static void run(Graph graph, List<String> results) {
        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-16s %-16s %-9s %-8s %-10s%n", "Operation", "Algorithm", "Size(N)", "Steps", "Time(ns)");
        System.out.println("---------------------------------------------------------------");

        int[] sizes = {100, 1000, 10000, 100000};
        for (int n : sizes) {
            SearchOps ops = new SearchOps();
            ops.generateSequential(n);
            int target = ops.getData()[n - 1]; // worst case for linear search
            SearchOps.Result lin = ops.linearSearch(target);
            SearchOps.Result bin = ops.binarySearch(target);
            print("Search", "Linear Search", n, lin.steps, lin.timeNs, results);
            print("Search", "Binary Search", n, bin.steps, bin.timeNs, results);
        }

        if (graph.getLastBfsSteps() == 0 && graph.getLastDfsSteps() == 0) {
            System.out.println("(Run BFS and DFS in the Graph menu to see traversal rows.)");
        } else {
            print("Graph Traversal", "BFS", -1, graph.getLastBfsSteps(), graph.getLastBfsTimeNs(), results);
            print("Graph Traversal", "DFS", -1, graph.getLastDfsSteps(), graph.getLastDfsTimeNs(), results);
        }
        System.out.println("===============================================================");
        System.out.println("Linear Search is O(n): steps grow with N. Binary Search is O(log n): steps barely grow.");
        System.out.println("BFS and DFS are both O(V + E). Time (ns) varies per run due to JVM/CPU noise,");
        System.out.println("so steps are the reliable measure of algorithmic cost.");
    }

    private static void print(String op, String algo, int n, int steps, long ns, List<String> results) {
        String size = n < 0 ? "-" : String.valueOf(n);
        System.out.printf("%-16s %-16s %-9s %-8d %-10d%n", op, algo, size, steps, ns);
        results.add(op + " | " + algo + " | N=" + size + " | steps=" + steps + " | " + ns + " ns");
    }
}
