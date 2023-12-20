190
        Reverse Bits
        2023-01-24 16:04:06

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
