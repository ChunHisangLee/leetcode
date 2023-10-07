
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][][] memo;
    final int MOD = (int) 1e9 + 7;

    public int numOfArrays(int n, int m, int k) {
        memo = new Integer[n + 1][k + 1][m + 1];
        return dp(n, m, k, 0);
    }

    private int dp(int n, int m, int k, int max) {
        if (k < 0 || n < k) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[n][k][max] != null) {
            return memo[n][k][max];
        }

        int sum = 0;

        for (int i = 1; i <= m; i++) {
            sum += dp(n - 1, m, i > max ? k - 1 : k, Math.max(i, max));
            sum %= MOD;
        }
        memo[n][k][max] = sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n][k][m];
        final int MOD = (int)1e9+7;
        long result = 0;

        Arrays.fill(dp[0][0], 1);

        for (int i = 1; i < n; i++) {
            for (int cost = 0; cost < Math.min(i + 1, k); cost++) {
                for (int max = 0; max < m; max++) {
                    long sum = 0;
                    sum += dp[i - 1][cost][max] * (max + 1);

                    if (cost != 0) {
                        long[] arr = dp[i - 1][cost - 1];
                        for (int prevMax = 0; prevMax < max; prevMax++) {
                            sum += arr[prevMax];
                        }
                    }

                    dp[i][cost][max] = sum % MOD;
                }
            }
        }

        for (int max = 0; max < m; max++) {
            result += dp[n - 1][k - 1][max];
            result %= MOD;
        }
        return (int) result;
    }
}
 */