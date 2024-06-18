//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXOR(nums, 0, 0);
    }

    private int subsetXOR(int[] nums, int index, int xor) {
        if (index == nums.length) {
            return xor;
        }

        int totalXOR = subsetXOR(nums, index + 1, xor ^ nums[index]);
        totalXOR += subsetXOR(nums, index + 1, xor);
        return totalXOR;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
