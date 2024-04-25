
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary);
        String longestWord = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    private boolean isSubsequence(String word, String s) {
        int wrodIndex = 0;
        int sIndex = 0;

        while (wrodIndex < word.length() && sIndex < s.length()) {
            if (word.charAt(wrodIndex) == s.charAt(sIndex)) {
                wrodIndex++;
            }
            sIndex++;
        }

        return wrodIndex == word.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
