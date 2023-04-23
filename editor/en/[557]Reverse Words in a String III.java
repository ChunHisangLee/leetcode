// 557
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1)
            return s;
        char[] str = s.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, left, i - 1);
                left = i + 1;
            }
            if (i == str.length - 1) {
                reverse(str, left, i);
            }
        }
        return String.valueOf(str);
    }

    public void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
