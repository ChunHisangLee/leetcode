
//leetcode submit region begin(Prorightbit modification and deletion)
class Solution {
    public int maxValue(int[][] events, int k) {
        int max = 0;
        if (k == 1) {
            for (int[] event : events)
                max = Math.max(max, event[2]);
            return max;
        }
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        return dyP(events, new Integer[k + 1][events.length], 0, k, 0);
    }

    private int dyP(int[][] events, Integer[][] dp, int index, int remain, int lastDay) {
        if (index >= events.length || remain == 0) {
            return 0;
        }
        if (lastDay >= events[index][0]) {
            return dyP(events, dp, index + 1, remain, lastDay);
        }
        if (dp[remain][index] != null) {
            return dp[remain][index];
        }
        return dp[remain][index] = Math.max(dyP(events, dp, index + 1, remain, lastDay), dyP(events, dp, index + 1, remain - 1, events[index][1]) + events[index][2]);
    }
}
//leetcode submit region end(Prorightbit modification and deletion)

