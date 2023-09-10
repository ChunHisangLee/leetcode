//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countOrders(int n) {
        final int MOD = (int) 1e9 + 7;
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i * (2 * i - 1)) % MOD;
        }
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 12ms
class Solution {
    final int MOD = (int) 1e9 + 7;
    long[][] dp;

    public int countOrders(int n) {
        dp = new long[n + 1][n + 1];
        return (int) dyP(n, n);
    }

    private long dyP(int unP, int unD) {
        if (unD == 0 && unP == 0) {
            return 1;
        }
        if (unD < 0 || unP < 0 || unD < unP) {
            return 0;
        }
        if (dp[unP][unD] != 0) {
            return dp[unP][unD];
        }
        long res = 0;
        res += (unP * dyP(unP - 1, unD) + (unD - unP) * dyP(unP, unD - 1));
        res %= MOD;
        return dp[unP][unD] = res;
    }
}

- 15 ms
class Solution {
    public int countOrders(int n) {
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                if (i > 0) {
                    dp[i][j] += i * dp[i - 1][j];
                }
                dp[i][j] %= MOD;
                if (j > i) {
                    dp[i][j] += (j - i) * dp[i][j - 1];
                }
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[n][n];
    }
}
 */