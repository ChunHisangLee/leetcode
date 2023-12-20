
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangularSum(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }

        return nums[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
