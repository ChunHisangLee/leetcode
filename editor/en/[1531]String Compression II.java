
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] memo = new int[s.length()][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dp(s, k, memo, 0);
    }

    private int dp(String s, int k, int[][] memo, int i) {
        if (k < 0) {
            return s.length();
        }

        if (i + k >= s.length()) {
            return 0;
        }

        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int result = dp(s, k - 1, memo, i + 1);
        int len = 0;
        int same = 0;
        int diff = 0;

        for (int j = i; j < s.length() && diff <= k; j++) {
            if (s.charAt(j) == s.charAt(i)) {
                same++;

                if (same <= 2 || same == 10 || same == 100) {
                    len++;
                }
            } else {
                diff++;
            }
            result = Math.min(result, len + dp(s, k - diff, memo, j + 1));
        }

        memo[i][k] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
