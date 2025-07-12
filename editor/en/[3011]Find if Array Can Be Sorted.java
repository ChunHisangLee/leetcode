
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canSortArray(int[] nums) {
        getSortWithBit(nums);
        return isSorted(nums);
    }

    private void getSortWithBit(int[] nums) {
        int start = 0;

        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || Integer.bitCount(nums[i]) != Integer.bitCount(nums[start])) {
                Arrays.sort(nums, start, i);
                start = i;
            }
        }
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
