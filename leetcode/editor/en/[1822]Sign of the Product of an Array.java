
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arraySign(int[] nums) {
        int sign = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign++;
            }
        }
        return sign % 2 == 0 ? 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
