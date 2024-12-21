
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] cuts = new int[1];
        dfs(0, -1, adj, values, k, cuts);
        return cuts[0] + 1;
    }

    private long dfs(int node, int parent, List<List<Integer>> adj, int[] values, int k, int[] cuts) {
        long currentSum = values[node];

        for(int neighbor : adj.get(node)) {
            if(neighbor != parent) {
                long childSum = dfs(neighbor, node, adj, values, k, cuts);
                currentSum += childSum;
            }
        }

        if(currentSum % k == 0 && parent != -1) {
            cuts[0]++;
            return 0;
        }

        return currentSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
