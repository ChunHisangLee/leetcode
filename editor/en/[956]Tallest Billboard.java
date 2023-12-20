
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[] dp = new int[sum + 1];
        for (int d = 1; d <= sum; d++) {
            dp[d] = -1;
        }
        for (int x : rods) {
            int[] prev = dp.clone();
            for (int d = 0; d + x <= sum; d++) {
                if (prev[d] < 0) {
                    continue;
                }
                int k = d + x;
                dp[k] = Math.max(dp[k], prev[d]);
                k = Math.abs(d - x);
                dp[k] = Math.max(dp[k], prev[d] + Math.min(d, x));
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
