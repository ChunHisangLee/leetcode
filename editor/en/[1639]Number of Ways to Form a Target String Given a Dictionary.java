
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int mod = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        char[] t = target.toCharArray();
        int m = words[0].length();
        int n = t.length;
        int[][] count = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) dyP(dp, count, t, 0, 0, m, n);
    }

    public long dyP(long[][] dp, int[][] count, char[] t, int i, int j, int m, int n) {
        if (j == n) {
            return 1;
        }
        if (m - i < n - j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long res = count[i][t[j] - 'a'] * dyP(dp, count, t, i + 1, j + 1, m, n);
        res += dyP(dp, count, t, i + 1, j, m, n);
        res %= mod;
        dp[i][j] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
