
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int index = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                dp[index] |= dp[index - 2];
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                dp[index] |= dp[index - 3];
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                dp[index] |= dp[index - 3];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
