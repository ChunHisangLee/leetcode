
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down dynamic programming - 3ms
class Solution {
    Integer[][] dp;

    public int numDistinct(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int m = c1.length;
        int n = c2.length;
        dp = new Integer[m][n];
        return dyP(c1, c2, 0, 0);
    }

    public int dyP(char[] c1, char[] c2, int i, int j) {
        int m = c1.length;
        int n = c2.length;
        if (i == m || j == n || m - i < n - j) {
            return j == n ? 1 : 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int res = dyP(c1, c2, i + 1, j);
        if (c1[i] == c2[j]) {
            res += dyP(c1, c2, i + 1, j + 1);
        }
        dp[i][j] = res;
        return res;
    }
}

Buttom-Up dyPnamic programming - 10 ms
class Solution {
    public int numDistinct(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
 */