//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if (index == -1) {
            return word;
        }

        String toReverse = word.substring(0, index + 1);
        String reversed = new StringBuilder(toReverse).reverse().toString();
        return reversed + word.substring(index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
