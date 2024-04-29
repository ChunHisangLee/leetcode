//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> graph;
    private int[] subtreeSize;
    private int[] distanceSum;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        subtreeSize = new int[n];
        distanceSum = new int[n];
        Arrays.fill(subtreeSize, 1);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        reroot(0, -1);
        return distanceSum;
    }

    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                subtreeSize[node] += subtreeSize[child];
                distanceSum[node] += distanceSum[child] + subtreeSize[child];
            }
        }
    }

    private void reroot(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                distanceSum[child] = distanceSum[node] - subtreeSize[child] + (subtreeSize.length - subtreeSize[child]);
                reroot(child, node);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
