5

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(getLen(s, i, i), getLen(s, i, i + 1));

            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + (len) / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    private int getLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
