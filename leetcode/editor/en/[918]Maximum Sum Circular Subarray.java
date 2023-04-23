918
        Maximum Sum Circular Subarray
        2023-01-18 09:12:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int max = nums[0];
        int currMin = 0;
        int min = nums[0];
        int total = 0;
        for (int num : nums) {
            currMax = Math.max(currMax + num, num);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + num, num);
            min = Math.min(min, currMin);
            total += num;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
