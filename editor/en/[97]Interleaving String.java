97
        Interleaving String
        2023-02-27 17:18:40

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        dp = new Boolean[m + 1][n + 1];
        if (s3.length() != m + n) {
            return false;
        }
        return dyP(s1, s2, s3, 0, 0);
    }

    private boolean dyP(String s1, String s2, String s3, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == s1.length() && j == s2.length() && i + j == s3.length()) {
            return true;
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res = res || dyP(s1, s2, s3, i + 1, j);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res = res || dyP(s1, s2, s3, i, j + 1);
        }
        return dp[i][j] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Bottom - UP - 3ms
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int m = c1.length;
        int n = c2.length;
        if (c3.length != m + n) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && c2[j - 1] == c3[i + j - 1];
                } else if (j == 0) {
                    dp[j] = dp[j] && c1[i - 1] == c3[i + j - 1];
                } else {
                    dp[j] = (dp[j - 1] && c2[j - 1] == c3[i + j - 1]) || (dp[j] && c1[i - 1] == c3[i + j - 1]);
                }
            }
        }
        return dp[n];
    }
}
 */