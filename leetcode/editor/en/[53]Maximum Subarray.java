53
        Maximum Subarray
        2023-01-18 09:23:55

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currMax = 0;
        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
