//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int index = 0;

        while (miss <= n) {
            if (index >= nums.length || nums[index] > miss) {
                count++;
                miss *= 2;
            } else {
                miss += nums[index];
                index++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
