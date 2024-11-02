
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[][] prefix = new int[26][n + 1];

        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[c][i + 1] = prefix[c][i];
            }

            char currentChar = s.charAt(i);
            prefix[currentChar - 'a'][i + 1]++;
        }

        int q = queries.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long count = 0;

            for (int c = 0; c < 26; c++) {
                int freq = prefix[c][right + 1] - prefix[c][left];

                if (freq > 0) {
                    count += ((long) freq * (freq + 1)) / 2;
                }
            }
            result[i] = (int) count;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
