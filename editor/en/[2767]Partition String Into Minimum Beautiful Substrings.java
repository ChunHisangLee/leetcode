//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int MAX_POWER_FIVE = 15625;

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }

            updateDP(s, dp, i, n);
        }

        return dp[n] > n ? -1 : dp[n];
    }

    private void updateDP(String s, int[] dp, int i, int n) {
        int curr = 0;

        for (int j = i; j < n; j++) {
            curr = curr * 2 + s.charAt(j) - '0';

            if (curr > MAX_POWER_FIVE) {
                break;
            }

            if (MAX_POWER_FIVE % curr == 0) {
                dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
