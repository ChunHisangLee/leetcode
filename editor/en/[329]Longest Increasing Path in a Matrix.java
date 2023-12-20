329
        Longest Increasing Path in a Matrix
        2023-02-18 12:15:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dp;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dyP(matrix, i, j));
            }
        }
        return max;
    }

    public int dyP(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], dyP(matrix, x, y));
            }

        }
        return ++dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
