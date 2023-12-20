123
        Best Time to Buy and Sell Stock III
        2023-03-06 17:56:18

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
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
