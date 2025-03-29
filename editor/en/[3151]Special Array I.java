
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
