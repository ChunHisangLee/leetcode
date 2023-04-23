
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arraySign(int[] nums) {
        int neg = 0;
        for (int item : nums) {
            if (item < 0)
                neg++;
            if (item == 0)
                return 0;
        }
        return neg % 2 == 0 ? 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
