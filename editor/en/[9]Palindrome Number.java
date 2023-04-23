//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int result = 0;
        int num = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
       return num == result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
