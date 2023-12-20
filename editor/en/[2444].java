2444
        Count Subarrays With Fixed Bounds
        2023-03-04 09:05:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minPos = -1;
        int maxPos = -1;
        int leftBound = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            res += Math.max(0, Math.min(minPos, maxPos) - leftBound);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
