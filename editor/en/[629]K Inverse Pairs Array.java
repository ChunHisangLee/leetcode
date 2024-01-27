
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kInversePairs(int n, int k) {
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            long count = 0;

            for (int j = 0; j <= k; j++) {
                count = (count + dp[i - 1][j]) % MOD;

                if (j >= i) {
                    count = (count - dp[i - 1][j - i] + MOD) % MOD;
                }

                dp[i][j] = (int) count;
            }
        }

        return dp[n][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
