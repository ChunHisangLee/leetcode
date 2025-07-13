//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] days;
    int[] costs;
    int[] durs = {1, 7, 30};
    Integer[] dp;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        n = days.length;
        dp = new Integer[n];
        return calculateMinCost(0);
    }

    private int calculateMinCost(int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;
        int j = i;

        for (int k = 0; k < 3; k++) {
            while (j < n && days[j] < days[i] + durs[k]) {
                j++;
            }

            minCost = Math.min(minCost, calculateMinCost(j) + costs[k]);
        }

        dp[i] = minCost;
        return minCost;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
