461
        Hamming Distance
        2022-12-15 14:18:25

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                count++;
            }
            xor /= 2;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
