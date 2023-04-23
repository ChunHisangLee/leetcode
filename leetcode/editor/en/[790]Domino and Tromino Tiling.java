790
        Domino and Tromino Tiling
        2022-12-24 09:16:36

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int MOD = (int) 1e9 + 7;
        long[] dp = new long[]{1, 2, 5};
        for (int i = 4; i <= n; i++) {
            long temp = dp[1];
            dp[1] = dp[2];
            dp[2] = (2 * dp[2] + dp[0]) % MOD;
            dp[0] = temp;
        }
        return (int) dp[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
