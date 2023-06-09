1059
        All Paths from Source Lead to Destination
        2023-02-04 11:50:07

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    enum Color {GRAY, BLACK}

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDest(graph, source, destination, new Color[n]);
    }

    private boolean leadsToDest(List<Integer>[] graph, int node, int dest, Color[] states) {
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }
        if (graph[node].isEmpty()) {
            return node == dest;
        }
        states[node] = Color.GRAY;
        for (int next : graph[node]) {
            if (!leadsToDest(graph, next, dest, states)) {
                return false;
            }
        }
        states[node] = Color.BLACK;
        return true;
    }

    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
