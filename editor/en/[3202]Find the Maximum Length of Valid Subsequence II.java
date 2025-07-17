
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(int[] nums, int k) {
        int res = 0;
        int[][] dp = new int[k][k];

        for (int num : nums) {
            for (int i = 0; i < k; i++) {
                dp[i][num % k] = dp[num % k][i] + 1;
                res = Math.max(res, dp[i][num % k]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
