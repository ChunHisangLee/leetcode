91
Decode Ways
        2023-02-23 18:17:12

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final char ZERO = '0';
    final char ONE = '1';
    final char TWO = '2';
    final char SIX = '6';

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == ZERO ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);

            if (c1 != ZERO) {
                dp[i] += dp[i - 1];
            }

            if (c2 == ONE || (c2 == TWO && c1 <= SIX)) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
