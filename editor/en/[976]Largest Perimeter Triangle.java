
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] - nums[i - 1] - nums[i - 2] < 0)
                return nums[i - 2] + nums[i - 1] + nums[i];
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
