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
        return helper(nums, 0, sum, new Boolean[nums.length + 1][sum + 1]);
    }

    private boolean helper(int[] nums, int currIndex, int sum, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (currIndex >= nums.length - 1 || sum < 0) {
            return false;
        }
        if (dp[currIndex][sum] != null) {
            return dp[currIndex][sum];
        }
        boolean res = helper(nums, currIndex + 1, sum - nums[currIndex + 1], dp) ||
                helper(nums, currIndex + 1, sum, dp);
        dp[currIndex][sum] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
