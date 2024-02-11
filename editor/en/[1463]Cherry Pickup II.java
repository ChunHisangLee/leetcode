//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];

        for (int[][] layer : dp) {
            for (int[] a : layer) {
                Arrays.fill(a, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, dyP(0, 0, m - 1, grid, dp));
    }

    public int dyP(int r, int c1, int c2, int[][] grid, int[][][] dp) {
        if (r == grid.length) {
            return 0;
        }

        if (dp[r][c1][c2] != Integer.MIN_VALUE) {
            return dp[r][c1][c2];
        }

        int ans = grid[r][c1];

        if (c1 != c2) {
            ans += grid[r][c2];
        }

        int temp = 0;

        for (int newc1 = c1 - 1; newc1 <= c1 + 1; newc1++) {
            for (int newc2 = c2 - 1; newc2 <= c2 + 1; newc2++) {
                if (newc1 >= 0 && newc1 < grid[0].length && newc2 >= 0 && newc2 < grid[0].length) {
                    temp = Math.max(temp, dyP(r + 1, newc1, newc2, grid, dp));
                }
            }
        }

        ans += temp;
        dp[r][c1][c2] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
