
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] dp;
    final int MOD = (int) 1e9 + 7;
    int m;
    int n;

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; i < n; ++j) {
                res = (res + dyP(grid, i, j)) % MOD;
            }
        }
        return res;
    }

    private int dyP(int[][] grid, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = i + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] < grid[i][j]) {
                res += dyP(grid, x, y);
                res %= MOD;
            }
        }
        dp[i][j] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
