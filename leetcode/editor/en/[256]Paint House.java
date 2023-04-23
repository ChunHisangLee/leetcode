256
        Paint House 2023-02-25 16:47:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int[][] dp = new int[m][3];
        dp[0] = costs[0].clone();
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)