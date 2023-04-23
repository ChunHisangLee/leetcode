1480
        Running Sum of 1dArray
        2022-12-05 18:04:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
