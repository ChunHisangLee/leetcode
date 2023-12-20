
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarrays(int[] nums) {
        int result = 0;
        int init = -1;

        for (int num : nums) {
            init &= num;
            if (init == 0) {
                init = -1;
                result++;
            }
        }

        return Math.max(1, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
