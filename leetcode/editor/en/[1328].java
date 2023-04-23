1328
        Break a Palindrome
        2023-03-06 11:28:15

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] ch = palindrome.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n / 2; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        ch[n - 1] = 'b';
        return String.valueOf(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
