
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int res = (max - k) - (min + k);
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
