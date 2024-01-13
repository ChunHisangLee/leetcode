1143
Longest Common
Subsequence
        2022-12-14 17:13:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length() + 1][text2.length() + 1];

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return getSequence(0, 0, text1, text2);
    }

    public int getSequence(int i, int j, String s1, String s2) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = getSequence(i + 1, j + 1, s1, s2) + 1;
        } else {
            memo[i][j] = Math.max(getSequence(i + 1, j, s1, s2), getSequence(i, j + 1, s1, s2));
        }

        return memo[i][j];
    }
}
 */