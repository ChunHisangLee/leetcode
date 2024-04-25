
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[128];
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int maxLengthForC = 0;
            int start = Math.max('a', c - k);
            int end = Math.min('z', c + k);

            for (int d = start; d <= end; d++) {
                maxLengthForC = Math.max(maxLengthForC, dp[d]);
            }

            dp[c] = maxLengthForC + 1;
            maxLength = Math.max(maxLength, dp[c]);
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
