122
        Best Time to Buy and Sell Stock II
        2023-02-24 16:14:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int notHold = 0;
        for (int price : prices) {
            int preHold = hold;
            int preNotHold = notHold;
            hold = Math.max(preHold, preNotHold - price);
            notHold = Math.max(preNotHold, preHold + price);
        }
        return notHold;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int notHold = 0;
        for (int price : prices) {
            hold = Math.max(hold, notHold - price);
            notHold = Math.max(notHold, hold + price);
        }
        return notHold;
    }
}
 */