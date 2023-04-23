276
        Paint Fence
        2023-02-23 13:53:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n, int k) {
        if (n <= 2) {
            return n == 2 ? k * k : k;
        }
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
