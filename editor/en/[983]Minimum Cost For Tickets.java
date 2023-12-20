983
        Minimum Cost For Tickets
        2023-02-27 15:49:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] days;
    int[] costs;
    int[] durs = new int[]{1, 7, 30};
    Integer[] dp;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        n = days.length;
        dp = new Integer[n];
        return dyP(0);
    }

    public int dyP(int i) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int j = i;
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            while (j < n && days[j] < days[i] + durs[k]) {
                j++;
            }
            res = Math.min(res, dyP(j) + costs[k]);
        }
        return dp[i] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
