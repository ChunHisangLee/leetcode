29
        Divide Two Integers
        2023-01-13 13:26:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        double res = x / y;
        return (int) res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
