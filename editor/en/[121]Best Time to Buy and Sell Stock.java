121
        Best Time to Buy and Sell Stock
        2023-02-24 16:06:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }

        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
