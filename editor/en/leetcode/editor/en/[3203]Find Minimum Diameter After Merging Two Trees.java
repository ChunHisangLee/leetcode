
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        int diameter1 = getDiameter(n, edges1);
        int diameter2 = getDiameter(m, edges2);

        int radius1 = (diameter1 + 1) / 2;
        int radius2 = (diameter2 + 1) / 2;

        return Math.max(Math.max(diameter1, diameter2), radius1 + radius2 + 1);
    }

    private int getDiameter(int numNodes, int[][] edges) {
        if (numNodes == 1) {
            return 0;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int farNode = bfs(0, adj, numNodes).node;
        BFSResult res = bfs(farNode, adj, numNodes);
        return res.dist;
    }

    private BFSResult bfs(int start, List<List<Integer>> adj, int numNodes) {
        boolean[] visited = new boolean[numNodes];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        int farthestNode = start;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = node;
            }

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return new BFSResult(farthestNode, maxDist);
    }

    private class BFSResult {
        int node;
        int dist;

        BFSResult(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
