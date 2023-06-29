
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        return dyP(c, 0, n - 1, dp);
    }

    public int dyP(char[] c, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (c[i] == c[j]) {
            dp[i][j] = dyP(c, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(dyP(c, i + 1, j, dp), dyP(c, i, j - 1, dp));
        }
        return dp[i][j];
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

 */