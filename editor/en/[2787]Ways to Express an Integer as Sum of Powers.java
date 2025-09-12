
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; ; i++) {
            long v = intPowBounded(i, x, n);
            if (v > n) {
                break;
            }
            powers.add((int) v);
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int p : powers) {
            for (int s = n; s >= p; s--) {
                dp[s] += dp[s - p];
                if (dp[s] >= MOD) {
                    dp[s] -= MOD;
                }
            }
        }
        return dp[n];
    }

    private long intPowBounded(int a, int b, int limit) {
        long res = 1;
        long base = a;
        int exp = b;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res *= base;
                if (res > limit) {
                    return (long) limit + 1;
                }
            }
            exp >>= 1;
            if (exp > 0) {
                base *= base;
                if (base > limit) {
                    base = (long) limit + 1;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
