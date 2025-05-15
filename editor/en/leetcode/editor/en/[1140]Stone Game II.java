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

        return helper(1, 0);
    }

    private int helper(int m, int p) {
        if (p + 2 * m >= preSum.length) {
            return preSum[p];
        }

        if (dp[p][m] > 0) {
            return dp[p][m];
        }

        int maxStone = 0;
        int take = 0;

        for (int i = 1; i <= 2 * m; i++) {
            take = preSum[p] - preSum[p + i];
            maxStone = Math.max(maxStone, take + preSum[p + i] - helper(Math.max(i, m), p + i));
        }

        dp[p][m] = maxStone;
        return maxStone;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
