5
        Longest Palindromic Substring
        2023-01-07 00:36:45

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            int len = Math.max(helper(c, i, i), helper(c, i, i + 1));
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public int helper(char[] c, int left, int right) {
        while (left >= 0 && right < c.length && c[left] == c[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
