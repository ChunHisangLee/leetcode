125
        Valid Palindrome
        2023-01-01 22:52:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
