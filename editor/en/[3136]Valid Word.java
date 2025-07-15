
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!Character.isLetterOrDigit(c)) {
                return false;
            }

            if (isVowel(c)) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
