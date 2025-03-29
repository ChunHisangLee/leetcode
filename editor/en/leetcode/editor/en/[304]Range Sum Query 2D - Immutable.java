
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private int[] dp;
    private int colsPlusOne;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            dp = new int[1];
            colsPlusOne = 1;
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        colsPlusOne = n + 1;
        dp = new int[(m + 1) * colsPlusOne];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentIndex = (i + 1) * colsPlusOne + (j + 1);
                int left = (i + 1) * colsPlusOne + j;
                int up = i * colsPlusOne + (j + 1);
                int upLeft = i * colsPlusOne + j;
                dp[currentIndex] = dp[left] + dp[up] - dp[upLeft] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp.length == 1) return 0; // Handle empty matrix case
        int bottomRight = (row2 + 1) * colsPlusOne + (col2 + 1);
        int bottomLeft = (row2 + 1) * colsPlusOne + col1;
        int topRight = row1 * colsPlusOne + (col2 + 1);
        int topLeft = row1 * colsPlusOne + col1;
        return dp[bottomRight] - dp[bottomLeft] - dp[topRight] + dp[topLeft];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
