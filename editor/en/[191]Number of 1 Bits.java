
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            counter++;
            n &= (n - 1);
        }
        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
