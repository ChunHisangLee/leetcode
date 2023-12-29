1335
        Minimum Difficulty of a Job Schedule
        2023-02-21 12:05:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        memo = new int[n][d + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return minDifficultyUtil(jobDifficulty, 0, d);
    }

    private int minDifficultyUtil(int[] jobDifficulty, int start, int d) {
        int n = jobDifficulty.length;

        if (d == 0 && start == n) {
            return 0;
        }

        if (d == 0 || start == n) {
            return Integer.MAX_VALUE;
        }

        if (memo[start][d] != -1) {
            return memo[start][d];
        }

        int maxDiff = 0;
        int minDifficulty = Integer.MAX_VALUE;

        for (int i = start; i < n; i++) {
            maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            int temp = minDifficultyUtil(jobDifficulty, i + 1, d - 1);

            if (temp != Integer.MAX_VALUE) {
                minDifficulty = Math.min(minDifficulty, temp + maxDiff);
            }
        }

        memo[start][d] = minDifficulty;
        return minDifficulty;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
