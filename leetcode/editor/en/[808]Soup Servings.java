
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Double[][] dp;

    public double soupServings(int n) {
        if (n >= 4800) {
            return 1.0;
        }
        int m = (n + 24) / 25;
        dp = new Double[m + 1][m + 1];
        return dyP(m, m);
    }

    private double dyP(int i, int j) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0.0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        dp[i][j] = (dyP(i - 4, j) + dyP(i - 3, j - 1) + dyP(i - 2, j - 2) + dyP(i - 1, j - 3)) / 4.0;
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
