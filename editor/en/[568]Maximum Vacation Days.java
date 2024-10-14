
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[k][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[0][0] = days[0][0];

        for (int i = 1; i < n; i++) {
            if (flights[0][i] == 1) {
                dp[0][i] = days[i][0];
            }
        }

        for (int week = 1; week < k; week++) {
            for (int city = 0; city < n; city++) {
                if (dp[week - 1][city] == -1) {
                    continue;
                }

                for (int nextCity = 0; nextCity < n; nextCity++) {
                    if (city == nextCity || flights[city][nextCity] == 1) {
                        dp[week][nextCity] = Math.max(dp[week][nextCity], dp[week - 1][city] + days[nextCity][week]);
                    }
                }
            }
        }

        int maxVacationDays = 0;

        for (int city = 0; city < n; city++) {
            maxVacationDays = Math.max(maxVacationDays, dp[k - 1][city]);
        }

        return maxVacationDays;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
