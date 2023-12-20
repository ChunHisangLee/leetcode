//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s.equals(p);
        }
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int m = cs.length;
        int n = cp.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (cp[i] == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
