
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long prefixSum = 0;
        int validSplits = 0;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            long rightSum = totalSum - prefixSum;

            if (prefixSum >= rightSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
