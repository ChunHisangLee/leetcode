
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int rank = Integer.MIN_VALUE;
        int[] edges = new int[n];
        int[][] isAdj = new int[n][n];
        for (int[] road : roads) {
            edges[road[0]]++;
            edges[road[1]]++;
            isAdj[road[0]][road[1]] = 1;
            isAdj[road[1]][road[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                rank = edges[i] + edges[j] - isAdj[i][j];
                res = Math.max(res, rank);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
