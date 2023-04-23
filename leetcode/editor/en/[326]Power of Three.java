326
        Power of Three
        2022-12-31 23:16:45

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
