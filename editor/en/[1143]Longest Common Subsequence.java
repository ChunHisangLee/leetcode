1143
        Longest Common Subsequence
        2022-12-14 17:13:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dp;
    char[] c1;
    char[] c2;

    public int longestCommonSubsequence(String text1, String text2) {
        c1 = text1.toCharArray();
        c2 = text2.toCharArray();
        dp = new int[c1.length + 1][c2.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dyP(0, 0);
    }

    public int dyP(int i, int j) {
        if (i >= c1.length || j >= c2.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (c1[i] == c2[j]) {
            dp[i][j] = dyP(i + 1, j + 1) + 1;
        } else {
            dp[i][j] = Math.max(dyP(i + 1, j), dyP(i, j + 1));
        }
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chText1 = text1.toCharArray();
        char[] chText2 = text2.toCharArray();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (chText1[i] == chText2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
 */