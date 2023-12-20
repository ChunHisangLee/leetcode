186
        Reverse Words in a String II
        2023-01-23 20:57:33

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEach(s);
    }

    public void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseEach(char[] s) {
        int n = s.length;
        int left = 0;
        int right = 0;
        while (left < n) {
            while (right < n && s[right] != ' ') {
                right++;
            }
            reverse(s,left, right - 1);
            left = right + 1;
            right++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
