
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int MOD = (int) 1e9 + 7;
    Long[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new Long[n + 1][goal + 1];
        return (int) dyP(0, 0, n, goal, k);
    }

    private long dyP(int used, int index, int n, int goal, int k) {
        if (index == goal) {
            return used == n ? 1 : 0;
        }
        if (dp[used][index] != null) {
            return dp[used][index];
        }
        long res = 0;
        if (used < n) {
            res += dyP(used + 1, index + 1, n, goal, k) * (n - used);
        }
        if (used > k) {
            res += dyP(used, index + 1, n, goal, k) * (used - k);
        }
        res %= MOD;
        return dp[used][index] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 1ms
class Solution {
    int MOD = (int) 1e9 + 7;
    Long[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new Long[n + 1][goal + 1];
        return (int) dyP(0, 0, n, goal, k);
    }

    private long dyP(int used, int index, int n, int goal, int k) {
        if (index == goal) {
            return used == n ? 1 : 0;
        }
        if (dp[used][index] != null) {
            return dp[used][index];
        }
        long res = 0;
        if (used < n) {
            res += dyP(used + 1, index + 1, n, goal, k) * (n - used);
        }
        if (used > k) {
            res += dyP(used, index + 1, n, goal, k) * (used - k);
        }
        res %= MOD;
        return dp[used][index] = res;
    }
}

Bottom-Up - 5ms
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }
        return (int) dp[goal][n];
    }
}

 */