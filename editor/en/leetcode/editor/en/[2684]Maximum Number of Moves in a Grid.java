
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 0;
        }

        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                int current = grid[i][j];

                if (i - 1 >= 0 && grid[i - 1][j + 1] > current) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j + 1]);
                }

                if (grid[i][j + 1] > current) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
                }

                if (i + 1 < m && grid[i + 1][j + 1] > current) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j + 1]);
                }
            }
        }

        int maxMoves = 0;

        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dp[i][0]);
        }

        return maxMoves;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
