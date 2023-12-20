
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long prevRegLane = 0;
        long prevExpLane = expressCost;
        long[] res = new long[n];
        for (int i = 1; i < n + 1; i++) {
            long regCost = regular[i - 1] + Math.min(prevRegLane, prevExpLane);
            long expCost = express[i - 1] + Math.min(expressCost + prevRegLane, prevExpLane);
            res[i - 1] = Math.min(regCost, expCost);
            prevRegLane = regCost;
            prevExpLane = expCost;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 43 ms
class Solution {
    Long[][] dp;

    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        dp = new Long[n][2];
        dyP(regular, express, expressCost, 1, n - 1);
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = dp[i][1];
        }
        return res;
    }

    private long dyP(int[] regular, int[] express, int expressCost, int lane, int i) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][lane] != null) {
            return dp[i][lane];
        }
        long regularLane = regular[i] + dyP(regular, express, expressCost, 1, i - 1);
        long expressLane = (lane == 1 ? expressCost : 0) + express[i] + dyP(regular, express, expressCost, 0, i - 1);
        dp[i][lane] = Math.min(regularLane, expressLane);
        return dp[i][lane];
    }
}
 */