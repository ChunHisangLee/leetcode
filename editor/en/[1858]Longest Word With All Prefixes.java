
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> validWords = new HashSet<>();
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || validWords.contains(word.substring(0, word.length() - 1))) {
                validWords.add(word);

                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
