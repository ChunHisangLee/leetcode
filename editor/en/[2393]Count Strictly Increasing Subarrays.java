
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums) {
        long count = 1;
        long length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                length = 1;
            }

            count += length;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
