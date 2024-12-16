
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int operation = 0; operation < k; operation++) {
            int minVal = nums[0];
            int minIndex = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < minVal) {
                    minVal = nums[i];
                    minIndex = i;
                }
            }

            nums[minIndex] = nums[minIndex] * multiplier;
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
