
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return getCount(nums, goal) - getCount(nums, goal - 1);
    }

    private int getCount(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            count += nums[right];
            while (count > k) {
                count -= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
