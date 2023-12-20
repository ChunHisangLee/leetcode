
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        int sum = 0;

        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (String word : words) {
            sum += checkWord(word, charCount);
        }

        return sum;
    }

    private int checkWord(String word, int[] charCount) {
        int[] wordCount = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            wordCount[x]++;

            if (wordCount[x] > charCount[x]) {
                return 0;
            }
        }

        return word.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
