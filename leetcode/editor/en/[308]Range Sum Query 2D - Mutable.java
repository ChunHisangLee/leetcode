

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] dp;
    int[][] matrix;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        cmpMatrix(0, 0);
    }

    public void update(int row, int col, int val) {
        matrix[row][col] = val;
        cmpMatrix(row, col);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }

    private void cmpMatrix(int row, int col) {
        for (int i = row; i < m; i++) {
            for (int j = col; j < n; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
