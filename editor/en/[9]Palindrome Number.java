//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            //  make sure reversed * 10 + x % 10 <= Integer.MAX_VALUE
            if (reversed > (Integer.MAX_VALUE - (x % 10)) / 10) {
                return false;
            }

            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return reversed == original;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
