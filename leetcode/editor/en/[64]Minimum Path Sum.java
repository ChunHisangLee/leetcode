64
        Minimum Path Sum
        2023-02-14 15:43:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dp;
    int[][] grid;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dyP(m - 1, n - 1);
    }

    public int dyP(int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return (int) 4e6;
        }
        if (dp[i][1] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Math.min((grid[i][j] + dyP(i - 1, j)), (grid[i][j] + dyP(i, j - 1)));
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
