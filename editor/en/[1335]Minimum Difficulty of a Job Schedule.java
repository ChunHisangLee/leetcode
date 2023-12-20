1335
        Minimum Difficulty of a Job Schedule
        2023-02-21 12:05:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] dp = new int[n][d];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int max = 0;
        for (int i = 0; i <= n - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            dp[i][0] = max;
        }
        for (int dayLeft = 1; dayLeft < d; dayLeft++) {
            for (int i = dayLeft; i <= n - d + dayLeft; i++) {
                int maxDiff = jobDifficulty[i];
                int res = Integer.MAX_VALUE;
                for (int j = i - 1; j >= dayLeft - 1; j--) {
                    res = Math.min(res, maxDiff + dp[j][dayLeft - 1]);
                    maxDiff = Math.max(maxDiff, jobDifficulty[j]);
                }
                dp[i][dayLeft] = res;
            }
        }
        return dp[n - 1][d - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
