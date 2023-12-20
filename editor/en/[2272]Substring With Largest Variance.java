
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestVariance(String s) {
        int res = 0;
        int[][] diffA = new int[26][26];
        int[][] diffB = new int[26][26];
        char[] c = s.toCharArray();
        for (int[] arr : diffB) {
            Arrays.fill(arr, -c.length);
        }
        for (int i = 0; i < c.length; i++) {
            int ch = c[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (j == ch) {
                    continue;
                }
                diffA[ch][j]++;
                diffB[ch][j]++;
                diffA[j][ch]--;
                diffB[j][ch] = diffA[j][ch];
                diffA[j][ch] = Math.max(diffA[j][ch], 0);
                res = Math.max(res, Math.max(diffB[ch][j], diffB[j][ch]));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
