//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = (n) * (n + 1) / 2;

        for (int num : nums) {
            result -= num;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
