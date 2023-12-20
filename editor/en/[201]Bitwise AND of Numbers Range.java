201
        Bitwise AND of Numbers Range
        2023-01-26 01:29:17

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return left & right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
