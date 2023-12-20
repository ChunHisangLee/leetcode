2484
        Count Palindromic Subsequences
        2022-11-27 09:18:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPalindromes(String s) {
        int mod = 1000_000_007;
        int size = 5;
        long ans = 0;
        for (char a = '0'; a <= '9'; a++) {
            for (char b = '0'; b <= '9'; b++) {
                char[] pattern = {a, b, '.', b, a};
                long[] dp = new long[size + 1];
                dp[size] = 1;
                for (char c : s.toCharArray()) {
                    for (int i = 0; i < size; i++) {
                        if (pattern[i] == '.' || pattern[i] == c)
                            dp[i] += dp[i + 1];
                    }
                }
                ans += dp[0];
                ans %= mod;
            }
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
