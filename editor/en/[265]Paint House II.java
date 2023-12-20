265
        Paint House II 2023-02-25 16:47:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostII(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        dp[0] = costs[0].clone();
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)