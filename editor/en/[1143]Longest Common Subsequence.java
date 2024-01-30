
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            getCommonSub(text1, text2, i, dp);
        }

        return dp[text2.length()];
    }

    private void getCommonSub(String text1, String text2, int i, int[] dp) {
        int prev = 0;

        for (int j = 0; j < text2.length(); j++) {
            int temp = dp[j + 1];

            if (text1.charAt(i) == text2.charAt(j)) {
                dp[j + 1] = prev + 1;
            } else {
                dp[j + 1] = Math.max(dp[j + 1], dp[j]);
            }

            prev = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[m][n];
    }
}

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