639
        Decode Ways II
        2023-02-23 18:17:17

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        long mod = (long) 1e9 + 7;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c1 == '*') {
                dp[i] = 9 * dp[i - 1] % mod;
                if (c2 == '1') {
                    dp[i] = (dp[i] + 9 * dp[i - 1]) % mod;
                } else if (c2 == '2') {
                    dp[i] = (dp[i] + 6 * dp[i - 1]) % mod;
                } else if (c2 == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 1]) % mod;
                }
            } else {
                dp[i] = c1 != '0' ? dp[i - 1] : 0;
                if (c2 == '1' || (c2 == '2' && c1 <= '6')) {
                    dp[i] = (dp[i] + dp[i - 1]) % mod;
                } else if (c2 == '*') {
                    dp[i] = (dp[i] + (c1 <= 6 ? 2 : 1) * dp[i - 1]) % mod;
                }
            }
        }
        return (int) dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
