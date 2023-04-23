53
        Maximum Subarray
        2023-03-06 17:23:54

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = 0;
        int max = nums[0];
        for (int num : nums) {
            currMax = Math.max(num, num + currMax);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
