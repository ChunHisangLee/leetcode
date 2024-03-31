//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int lastMin = -1;
        int lastMax = -1;
        int lastInvalid = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastMin = i;
                lastMax = i;
                lastInvalid = i;
            }

            if (nums[i] == minK) {
                lastMin = i;
            }

            if (nums[i] == maxK) {
                lastMax = i;
            }

            count += Math.min(lastMin, lastMax) - lastInvalid;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
