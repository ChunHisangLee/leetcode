
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        double res = 1;
        for (long i = num; i > 0; i /= 2) {
            if ((i % 2 == 1)) {
                res *= x;
            }
            x = x * x;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
