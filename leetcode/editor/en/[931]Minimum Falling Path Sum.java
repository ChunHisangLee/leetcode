931
        Minimum Falling Path Sum
        2022-12-13 09:41:58

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0] = matrix[0].clone();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : dp[n - 1]) {
            res = Math.min(res, num);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)