// 121
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i])
                min = prices[i];
            if (prices[i] - min > profit)
                profit = prices[i] - min;
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
