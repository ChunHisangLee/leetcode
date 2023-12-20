
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOneBitOperations(int n) {
        int sign = 1;
        int res = 0;

        while (n > 0) {
            res += n ^ (n - 1) * sign;
            n &= n - 1;
            sign = -sign;
        }

        return Math.abs(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minimumOneBitOperations(int n) {
        return getCount(n, 0);
    }

    private int getCount(int n, int res) {
        if (n == 0) {
            return res;
        }

        int b = 1;

        while ((b << 1) <= n) {
            b = b << 1;
        }

        return getCount((b >> 1) ^ b ^ n, res + b);
    }
}
 */