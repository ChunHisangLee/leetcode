
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    continue;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                    if (c[i] == c[j]) {
                        dp[i][j]--;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down -34 ms
class Solution {
    Integer[][] dp;

    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        dp = new Integer[n][n];
        return dyP(c, 0, n - 1);
    }

    private int dyP(char[] c, int left, int right) {
        if (left == right) {
            return 1;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            res = Math.min(res, dyP(c, left, i) + dyP(c, i + 1, right));
        }
        return dp[left][right] = c[left] == c[right] ? res - 1 : res;
    }
}

Bottom-Up - 13 ms
class Solution {
    public int strangePrinter(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    continue;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                    if (c[i] == c[j]) {
                        dp[i][j]--;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
 */