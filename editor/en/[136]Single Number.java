//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int n : nums) {
            result ^= n;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
