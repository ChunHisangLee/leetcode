//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            if (col[i] == 0 && !dfs(graph, i, 1, col)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int i, int c, int[] col) {
        if (col[i] != 0) {
            return col[i] == c;
        }
        col[i] = c;
        for (int num : graph[i]) {
            if (!dfs(graph, num, c * -1, col)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
