//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public long maxPoints(int[][] points) {
        int n = points[0].length;
        long[] dp = new long[n];
        long[] newDp = new long[n];

        for (int[] row : points) {
            long curMax = 0;

            for (int c = 0; c < n; c++) {
                curMax = Math.max(curMax - 1, newDp[c]);
                dp[c] = curMax;
            }

            curMax = 0;

            for (int c = n - 1; c >= 0; c--) {
                curMax = Math.max(curMax - 1, newDp[c]);
                dp[c] = Math.max(dp[c], curMax) + row[c];
            }

            newDp = dp;
        }

        long result = 0;

        for (int c = 0; c < n; c++) {
            result = Math.max(result, newDp[c]);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
