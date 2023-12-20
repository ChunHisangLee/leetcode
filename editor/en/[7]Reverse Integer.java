7
        Reverse Integer
        2023-01-01 22:19:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
            x /= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
