9
Palindrome Number
2023-01-02 00:21:24
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;}
        int res = 0;
        int num = x;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return num == res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
