
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int res = 1;

        while (n > 4) {
            n -= 3;
            res *= 3;
        }

        return n * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
