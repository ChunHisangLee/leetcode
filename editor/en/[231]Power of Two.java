231
        Power of Two
        2022-12-31 23:15:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
