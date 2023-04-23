
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < w1.length || j < w2.length) {
            if (i < w1.length) {
                sb.append(w1[i]);
                i++;
            }
            if (j < w2.length) {
                sb.append(w2[j]);
                j++;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
