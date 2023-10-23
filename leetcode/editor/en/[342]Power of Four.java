342
        Power of Four
        2022-12-31 23:19:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
