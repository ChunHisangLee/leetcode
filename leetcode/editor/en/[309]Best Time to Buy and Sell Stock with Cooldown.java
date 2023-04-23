309
        Best Time to Buy and Sell Stock with Cooldown
        2023-02-22 18:00:09

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int notHold = 0;
        int coolDown = 0;
        for (int price : prices) {
            int preHold = hold;
            int preNotHold = notHold;
            int preCool = coolDown;
            hold = Math.max(preHold, preCool - price);
            notHold = preHold + price;
            coolDown = Math.max(preCool, preNotHold);
        }
        return Math.max(coolDown, notHold);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
 */