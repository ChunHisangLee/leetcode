2330
        Valid Palindrome IV
        2023-01-01 22:52:25

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makePalindrome(String s) {
        int count = 0;
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                count++;
            }
        }
        return count < 3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
