// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        dp[c] = dp[c] + dp[c - 1];
      }
    }

    return dp[n - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
