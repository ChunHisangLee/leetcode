
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[high + 1];
        dp[0] = 1;
        long res = 0;

        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
                dp[i] %= MOD;
            }

            if (i >= one) {
                dp[i] += dp[i - one];
                dp[i] %= MOD;
            }

            if (i >= low) {
                res += dp[i];
                res %= MOD;
            }
        }

        return (int) res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
