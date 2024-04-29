
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!isVowel(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
