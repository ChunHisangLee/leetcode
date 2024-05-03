
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long subsequenceSumOr(int[] nums) {
        long result = 0L;
        long sum = 0L;

        for (int num : nums) {
            sum += num;
            result |= num;
            result |= sum;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
