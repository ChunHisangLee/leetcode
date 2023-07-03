
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + c1[i - 1];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + c2[j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + c1[i - 1], dp[i][j - 1] + c2[j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down dynamic programming - 34ms
由後往前算，答案會不一樣，因為dp[i][j]只能記錄值，無法確定是不是最小的

class Solution {
    Integer[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        dp = new Integer[m][n];
        return dyP(c1, c2, 0, 0);
    }

    private int dyP(char[] c1, char[] c2, int i, int j) {
        if (i == c1.length) {
            int sum = 0;
            while (j < c2.length) {
                sum += (int) c2[j];
                j++;
            }
            return sum;
        }
        if (j == c2.length) {
            int sum = 0;
            while (i < c1.length) {
                sum += (int) c1[i];
                i++;
            }
            return sum;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (c1[i] == c2[j]) {
            dp[i][j] = dyP(c1, c2, i + 1, j + 1);
        } else {
            dp[i][j] = Math.min((int) c1[i] + dyP(c1, c2, i + 1, j), (int) c2[j] + dyP(c1, c2, i, j + 1));
        }
        return dp[i][j];
    }
}

Buttom-Up dyPnamic programming - 8ms
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + c1[i - 1];
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + c2[j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + c1[i - 1], dp[i][j - 1] + c2[j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
 */