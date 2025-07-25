// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int i = 1; i <= n; i++) {
      for (String word : wordDict) {
        int len = word.length();

        if (i >= len && dp[i - len]) {
          if (s.substring(i - len, i).equals(word)) {
            dp[i] = true;
            break;
          }
        }
      }
    }

    return dp[n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
