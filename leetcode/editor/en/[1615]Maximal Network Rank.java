
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
            edge[road[0]]++;
            edge[road[1]]++;
            adj[road[0]][road[1]] = 1;
            adj[road[1]][road[0]] = 1;
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
