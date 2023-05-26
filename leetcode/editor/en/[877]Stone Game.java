
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[i + d] - dp[i]);
            }
        }
        return dp[0] > 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
 */
