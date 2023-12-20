1444
        Number of count of Cutting a Pizza
        2023-03-06 15:01:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] arr = new int[m + 1][n + 1];
        long[][][] dp = new long[k][m][n];
        int MOD = (int) 1e9 + 7;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                arr[i][j] = arr[i + 1][j] + arr[i][j + 1] - arr[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[0][i][j] = arr[i][j] > 0 ? 1 : 0;
            }
        }
        for (int remain = 1; remain < k; remain++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    for (int nextI = i + 1; nextI < m; nextI++) {
                        if (arr[i][j] - arr[nextI][j] > 0) {
                            dp[remain][i][j] += dp[remain - 1][nextI][j];
                        }
                    }
                    for (int nextJ = j + 1; nextJ < n; nextJ++) {
                        if (arr[i][j] - arr[i][nextJ] > 0) {
                            dp[remain][i][j] += dp[remain - 1][i][nextJ];
                        }
                    }
                }
            }
        }
        return (int) (dp[k - 1][0][0] % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
