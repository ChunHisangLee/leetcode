188
        Best Time to Buy and Sell Stock IV
        2022-12-14 17:31:45

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] cost = new int[k + 1];
        int[] profit = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }
        return profit[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int hold = 0; hold < 2; hold++) {
                    int notTrade = dp[i + 1][j][hold];
                    int doTrade;
                    if (hold == 1) {
                        doTrade = prices[i] + dp[i + 1][j - 1][0];
                    } else {
                        doTrade = -prices[i] + dp[i + 1][j][1];
                    }
                    dp[i][j][hold] = Math.max(doTrade, notTrade);
                }
            }
        }
        return dp[0][k][0];
    }
}
 */
