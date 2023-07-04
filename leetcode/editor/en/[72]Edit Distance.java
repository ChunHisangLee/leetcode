72
        Edit Distance
        2023-02-26 09:20:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    Integer[][] dp;

    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        dp = new Integer[m + 1][n + 1];
        return dyP(c1, c2, m, n);
    }

    private int dyP(char[] c1, char[] c2, int i, int j) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int dist = 0;
        if (c1[i - 1] == c2[j - 1]) {
            dist = dyP(c1, c2, i - 1, j - 1);
        } else {
            int insertOp = dyP(c1, c2, i, j - 1);
            int deleteOp = dyP(c1, c2, i - 1, j);
            int replaceOp = dyP(c1, c2, i - 1, j - 1);
            dist = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
        }
        return dp[i][j] = dist;
    }
}

Buttom-Up dyPnamic programming -4ms
class Solution {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
 */