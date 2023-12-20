
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        final int MOD = (int) 1e9 + 7;
        long pre[] = new long[10];
        long curr[] = new long[10];
        long count = 0;
        Arrays.fill(pre, 1);

        while (--n > 0) {
            curr[0] = (pre[4] + pre[6]) % MOD;
            curr[1] = (pre[6] + pre[8]) % MOD;
            curr[2] = (pre[7] + pre[9]) % MOD;
            curr[3] = (pre[4] + pre[8]) % MOD;
            curr[4] = (pre[3] + pre[9] + pre[0]) % MOD;
            curr[6] = (pre[1] + pre[7] + pre[0]) % MOD;
            curr[7] = (pre[2] + pre[6]) % MOD;
            curr[8] = (pre[1] + pre[3]) % MOD;
            curr[9] = (pre[2] + pre[4]) % MOD;

            for (int i = 0; i < 10; i++) {
                pre[i] = curr[i];
            }
        }

        for (int i = 0; i < 10; i++) {
            count = (count + curr[i]) % MOD;
        }

        return (int) count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int knightDialer(int n) {
        final int MOD = (int) 1e9 + 7;
        int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n][10];
        int count = 0;
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int move : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][move]) % MOD;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            count = (count + dp[n - 1][i]) % MOD;
        }

        return count;
    }
}

class Solution {
    final int MOD = (int) 1e9 + 7;
    int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    Integer[][] memo;

    public int knightDialer(int n) {
        memo = new Integer[n + 1][10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            count = (count + getCount(n, i)) % MOD;
        }

        return count;
    }

    private int getCount(int n, int digit) {
        if (n == 1) {
            return 1;
        }

        if (memo[n][digit] != null) {
            return memo[n][digit];
        }

        memo[n][digit] = 0;
        for (int move : moves[digit]) {
            memo[n][digit] = (memo[n][digit] + getCount(n - 1, move)) % MOD;
        }

        return memo[n][digit];
    }
}
 */