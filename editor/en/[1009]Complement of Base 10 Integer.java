
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int bitmast = (Integer.highestOneBit(n) << 1) - 1;
        return n ^ bitmast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
