953
        Verifying an Alien Dictionary 2023-02-02 09:54:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            int len1 = words[i].length();
            int len2 = words[i + 1].length();
            int n = len1 > len2 ? len2 : len1;
            for (int j = 0; j < n; j++) {
                char word1 = words[i].charAt(j);
                char word2 = words[i + 1].charAt(j);
                if (order.indexOf(word1) < order.indexOf(word2)) {
                    break;
                } else if (order.indexOf(word1) > order.indexOf(word2)) {
                    return false;
                } else {
                    if (j == n - 1 && len1 > len2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
