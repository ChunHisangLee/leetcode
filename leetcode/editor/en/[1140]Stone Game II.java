
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dp;
    int[] preSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        preSum = piles.clone();
        for (int i = n - 2; i >= 0; i--) {
            preSum[i] += preSum[i + 1];
        }
        return dyP(1, 0);
    }

    private int dyP(int m, int p) {
        if (p + 2 * m >= preSum.length) {
            return preSum[p];
        }
        if (dp[p][m] > 0) {
            return dp[p][m];
        }
        int res = 0;
        int take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            take = preSum[p] - preSum[p + i];
            res = Math.max(res, take + preSum[p + i] - dyP(Math.max(i, m), p + i));
        }
        dp[p][m] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DP - Bottom-Up: -7ms
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] preSum = piles.clone();
        for (int i = n - 2; i >= 0; i--) {
            preSum[i] += preSum[i + 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = preSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int opponentScore = dp[i + x][Math.max(x, m)];
                        int score = preSum[i] - opponentScore;
                        dp[i][m] = Math.max(dp[i][m], score);
                    }
                }
            }
        }

        return dp[0][1];
    }
}

DP - Top-Down: -3ms
class Solution {
    int[][] dp;
    int[] preSum;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        preSum = piles.clone();
        for (int i = n - 2; i >= 0; i--) {
            preSum[i] += preSum[i + 1];
        }
        return dyP(1, 0);
    }

    private int dyP(int m, int p) {
        if (p + 2 * m >= preSum.length) {
            return preSum[p];
        }
        if (dp[p][m] > 0) {
            return dp[p][m];
        }
        int res = 0;
        int take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            take = preSum[p] - preSum[p + i];
            res = Math.max(res, take + preSum[p + i] - dyP(Math.max(i, m), p + i));
        }
        dp[p][m] = res;
        return res;
    }
}
 */