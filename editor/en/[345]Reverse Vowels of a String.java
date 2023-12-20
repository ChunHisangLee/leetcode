
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            while (!isVowel(c[left]) && left < right) {
                left++;
            }

            while ((!isVowel(c[right]) && left < right)) {
                right--;
            }

            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }

        return new String(c);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
