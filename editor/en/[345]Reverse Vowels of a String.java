// 345
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            while (!isV(ch[right]) && left < right) {
                right--;
            }
            while (!isV(ch[left]) && left < right) {
                left++;
            }
            char temp = ch[right];
            ch[right] = ch[left];
            ch[left] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }

    private boolean isV(char c) {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i'
                || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
