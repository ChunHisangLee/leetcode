541
Reverse String II
        2022-12-21 22:38:07

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] word = s.toCharArray();

        for (int i = 0; i < word.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, word.length - 1);

            while (left < right) {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(word);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
