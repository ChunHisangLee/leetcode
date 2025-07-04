// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int lowestBit = n & 1;
      result <<= 1;
      result |= lowestBit;
      n >>>= 1;
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
