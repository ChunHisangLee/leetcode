191
        Number of 1Bits
        2023-01-24 15:10:04

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
