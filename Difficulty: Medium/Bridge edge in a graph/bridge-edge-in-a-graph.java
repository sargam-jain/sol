//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to perform BFS and count components
    static void bfs(int src, List<List<Integer>> adj, int c, int d, boolean skipEdge, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : adj.get(node)) {
                // Skip the edge (c, d)
                if (skipEdge && ((node == c && next == d) || (node == d && next == c))) {
                    continue;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    // Function to check if the edge (c, d) is a bridge in the graph
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // Create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Count components before removing the edge c-d
        boolean[] visited = new boolean[V];
        int initialDisjointSets = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i, adj, c, d, false, visited);
                initialDisjointSets++;
            }
        }

        // Count components after removing the edge c-d
        Arrays.fill(visited, false);
        int afterDisjointSets = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i, adj, c, d, true, visited);
                afterDisjointSets++;
            }
        }

        // If the number of disjoint sets changed, the edge is a bridge
        return initialDisjointSets != afterDisjointSets;
    }
}

// Example usage




//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends