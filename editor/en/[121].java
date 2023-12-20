121
        Best Time to Buy and Sell Stock
        2023-03-06 17:44:29

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int currMax = 0;
        int max = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            currMax = Math.max(0, currMax += prices[i] - prices[i - 1]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
