
//leetcode submit region begin(Prohibit modification and deletion)
class Graph {

    private List<List<int[]>> adjList;

    public Graph(int n, int[][] edges) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        adjList.get(from).add(new int[]{to, cost});
    }

    public int shortestPath(int node1, int node2) {
        int n = adjList.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{node1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            if (node == node2) {
                return cost;
            }

            for (int[] neighbor : adjList.get(node)) {
                int nextNode = neighbor[0], edgeCost = neighbor[1];

                if (cost + edgeCost < dist[nextNode]) {
                    dist[nextNode] = cost + edgeCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
//leetcode submit region end(Prohibit modification and deletion)
