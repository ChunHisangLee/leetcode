680
        Valid Palindrome II
        2023-01-01 22:52:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {
        for (int left = i, right = j; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
