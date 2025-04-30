// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] dp = new int[rows + 1][cols + 1];
    int maxLen = 0;

    for (int r = 1; r <= rows; r++) {
      for (int c = 1; c <= cols; c++) {
        if (matrix[r - 1][c - 1] == '1') {
          int top = dp[r - 1][c];
          int left = dp[r][c - 1];
          int diag = dp[r - 1][c - 1];
          dp[r][c] = Math.min(top, Math.min(left, diag)) + 1;
          maxLen = Math.max(maxLen, dp[r][c]);
        }
      }
    }

    return maxLen * maxLen;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
