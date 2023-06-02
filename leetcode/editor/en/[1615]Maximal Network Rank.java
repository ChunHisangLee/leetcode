
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int rank = Integer.MIN_VALUE;
        int[] edge = new int[n];
        int[][] adj = new int[n][n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            edge[x]++;
            edge[y]++;
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                rank = edge[i] + edge[j] - adj[i][j];
                res = Math.max(res, rank);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
