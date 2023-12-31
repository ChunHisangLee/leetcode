
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int bitwiseOR = nums[i] | nums[j];

                if ((bitwiseOR & 1) == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
