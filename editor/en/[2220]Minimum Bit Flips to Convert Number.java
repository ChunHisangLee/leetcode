
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minBitFlips(int start, int goal) {
        int xorNum = start ^ goal;
        return Integer.bitCount(xorNum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
