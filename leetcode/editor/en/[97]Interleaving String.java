97
        Interleaving String
        2023-02-27 17:18:40

//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
