// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numDecodings(String s) {
    int n = s.length();

    if (n == 0 || s.charAt(0) == '0') {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }

      int two = Integer.parseInt(s.substring(i - 2, i));
      if (two >= 10 && two <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
