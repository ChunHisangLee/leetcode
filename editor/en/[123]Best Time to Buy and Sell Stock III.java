123
        Best Time to Buy and Sell Stock III
        2023-02-24 17:44:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int[] cost = new int[3];
        int[] profit = new int[3];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 1; i < 3; i++) {
                cost[i] = Math.min(cost[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }
        return profit[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
