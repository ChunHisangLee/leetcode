/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        int mod = (int) 1e9 + 7;
        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = minProfit; 0 <= i; i--) {
                for (int j = n; g <= j; j--) {
                    dp[i][j] = (dp[i][j] + dp[Math.max(0, i - p)][j - g]) % mod;
                }
            }
        }
        int res = 0;
        for (int num : dp[minProfit]) {
            res = (res + num) % mod;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
