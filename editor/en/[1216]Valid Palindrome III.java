1216
        Valid Palindrome III
        2023-01-01 22:52:30
/*
還不會
跟 1682 很像
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            int max = 0;
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                tmp = dp[j];
                if (c[i] == c[j]) {
                    dp[j] = Math.max(dp[j], max + 2);
                }
                if (tmp > max) {
                    max = tmp;
                }
                if (n - dp[j] <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
