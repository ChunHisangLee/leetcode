// 50
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        while (n != 0) {
            if (n > 0) {
                if (n % 2 == 0) {
                    x = x * x;
                    n = n / 2;
                } else {
                    result = result * x;
                    n = n - 1;
                }
            } else {
                if (n % 2 == 0) {
                    x = x * x;
                    n = n / 2;
                } else {
                    result = result / x;
                    n = n + 1;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
