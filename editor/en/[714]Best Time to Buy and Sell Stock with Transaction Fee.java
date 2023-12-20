714
        Best Time to Buy and Sell Stock with Transaction Fee
        2023-02-24 16:05:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = Integer.MIN_VALUE;
        int notHold = 0;
        for (int price : prices) {
            int preHold = hold;
            int preNotHold = notHold;
            hold = Math.max(preHold, preNotHold - price - fee);
            notHold = Math.max(preNotHold, preHold + price);
        }
        return notHold;
    }
}
//leetcode submit region end(Prohibit modification and deletion)