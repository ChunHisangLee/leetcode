
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            String nextWord = words[(i + 1) % n];
            char lastCurrentChar = currentWord.charAt(currentWord.length() - 1);
            char firstNextChar = nextWord.charAt(0);

            if (lastCurrentChar != firstNextChar) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
