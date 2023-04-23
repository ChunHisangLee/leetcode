1473
        Paint House III
        2023-02-25 16:50:42

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int MAX = 1000001;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][] prevDp = new int[target + 1][n];
        for (int i = 0; i <= target; i++) {
            Arrays.fill(prevDp[i], MAX);
        }
        for (int i = 1; i <= n; i++) {
            if (houses[0] == i) {
                prevDp[1][i - 1] = 0;
            } else if (houses[0] == 0) {
                prevDp[1][i - 1] = cost[0][i - 1];
            }
        }
        for (int house = 1; house < m; house++) {
            int[][] dp = new int[target + 1][n];
            for (int i = 0; i <= target; i++) {
                Arrays.fill(dp[i], MAX);
            }
            for (int nei = 1; nei <= Math.min(target, house + 1); nei++) {
                for (int i = 1; i <= n; i++) {
                    if (houses[house] == 0 || i == houses[house]) {
                        int curr = MAX;
                        for (int prev = 1; prev <= n; prev++) {
                            if (prev != i) {
                                curr = Math.min(curr, prevDp[nei - 1][prev - 1]);
                            } else {
                                curr = Math.min(curr, prevDp[nei][i - 1]);
                            }
                        }
                        int costToPaint = houses[house] != 0 ? 0 : cost[house][i - 1];
                        dp[nei][i - 1] = curr + costToPaint;
                    }
                }
            }
            prevDp = dp;
        }
        int res = MAX;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, prevDp[target][i - 1]);
        }
        return res == MAX ? -1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
