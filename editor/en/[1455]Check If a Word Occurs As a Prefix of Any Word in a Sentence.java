
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String word = words[i];

            if (word.startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
