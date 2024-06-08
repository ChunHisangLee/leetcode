
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letter_count = new int[26];

        for (char letter : letters) {
            letter_count[letter - 'a']++;
        }

        int[] wordScores = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordScores[i] += score[c - 'a'];
            }
        }

        return backtrack(words, wordScores, letter_count, 0);
    }

    private int backtrack(String[] words, int[] wordScores, int[] letter_count, int index) {
        if (index == words.length) {
            return 0;
        }

        int maxScore = backtrack(words, wordScores, letter_count, index + 1);
        boolean canInclude = true;
        int[] temp_count = letter_count.clone();

        for (char c : words[index].toCharArray()) {
            if (--temp_count[c - 'a'] < 0) {
                canInclude = false;
                break;
            }
        }

        if (canInclude) {
            maxScore = Math.max(maxScore, wordScores[index] + backtrack(words, wordScores, temp_count, index + 1));
        }

        return maxScore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
