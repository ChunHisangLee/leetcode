
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
        int bitmask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ bitmask;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
