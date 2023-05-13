
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        final int MOD = (int) 1e9 + 7;
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }
            if (i >= one) {
                dp[i] += dp[i - one];
            }
            dp[i] %= MOD;
            if (i >= low) {
                res += dp[i];
                res %= MOD;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
