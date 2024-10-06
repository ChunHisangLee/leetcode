
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.trim().split(" ");
        String[] words2 = sentence2.trim().split(" ");

        if (words1.length < words2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int m = words1.length;
        int n = words2.length;
        int i = 0;

        while (i < n && words1[i].equals(words2[i])) {
            i++;
        }

        if (i == n) {
            return true;
        }

        int j = 0;

        while (j < n - i && words1[m - 1 - j].equals(words2[n - 1 - j])) {
            j++;
        }

        return i + j == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
