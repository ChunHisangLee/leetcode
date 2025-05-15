
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        for (int[][] dp2 : dp) {
            for (int[] row : dp2) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = grid[0][0];

        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    int c2 = r1 + c1 - r2;

                    if (c2 < 0 || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }

                    int cherries = grid[r1][c1];

                    if (r1 != r2 || c1 != c2) {
                        cherries += grid[r2][c2];
                    }

                    if (r1 > 0 && r2 > 0) {
                        dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1 - 1][c1][r2 - 1] + cherries);
                    }

                    if (r1 > 0 && c2 > 0) {
                        dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1 - 1][c1][r2] + cherries);
                    }

                    if (c1 > 0 && r2 > 0) {
                        dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1][c1 - 1][r2 - 1] + cherries);
                    }

                    if (c1 > 0 && c2 > 0) {
                        dp[r1][c1][r2] = Math.max(dp[r1][c1][r2], dp[r1][c1 - 1][r2] + cherries);
                    }
                }
            }
        }

        return Math.max(0, dp[n - 1][n - 1][n - 1]);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
