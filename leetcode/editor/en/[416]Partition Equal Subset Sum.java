//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        return dyP(nums, 0, sum, new Boolean[nums.length + 1][sum + 1]);
    }

    public boolean dyP(int[] nums, int curr, int sum, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (curr >= nums.length - 1 || sum < 0) {
            return false;
        }
        if (dp[curr][sum] != null) {
            return dp[curr][sum];
        }
        boolean res = dyP(nums, curr + 1, sum - nums[curr + 1], dp) || dyP(nums, curr + 1, sum, dp);
        dp[curr][sum] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
