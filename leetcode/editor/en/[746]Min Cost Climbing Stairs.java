746
        Min Cost Climbing Stairs
        2022-12-14 13:57:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1]+cost[i-1], dp[i - 2]+cost[i-2]);
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
