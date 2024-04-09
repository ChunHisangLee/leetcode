
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] >= benchMark) {
                if (i <= k) {
                    count += benchMark;
                } else {
                    count += benchMark - 1;
                }
            } else {
                count += tickets[i];
            }
        }

        return count;
    }
}
/*
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;

        for (int i = 0; i < tickets.length; i++) {
            count += Math.min(tickets[i], tickets[k] - (i > k ? 1 : 0));
        }

        return count;
    }
}
 */
//leetcode submit region end(Prohibit modification and deletion)
