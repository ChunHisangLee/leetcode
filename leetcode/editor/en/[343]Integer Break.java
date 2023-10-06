
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }

        if (n % 3 == 1) {
            return 4 * (int) Math.pow(3, (n - 4) / 3);
        }

        return 2 * (int) Math.pow(3, (n - 2) / 3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int result = 1;

        while (n > 4) {
            n -= 3;
            result *= 3;
        }

        return result * n;
    }
}
 */
