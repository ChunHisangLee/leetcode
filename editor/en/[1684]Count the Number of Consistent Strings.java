
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] charSet = new boolean[26];

        for (char c : allowed.toCharArray()) {
            charSet[c - 'a'] = true;
        }

        int count = 0;

        for (String word : words) {
            boolean isConsistent = true;
            int n = word.length();

            for (int i = 0; i < n; i++) {
                if (!charSet[word.charAt(i) - 'a']) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
