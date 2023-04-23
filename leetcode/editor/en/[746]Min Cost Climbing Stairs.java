746
        Min Cost Climbing Stairs
        2022-12-14 13:57:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int backOne = cost[1];
        int backTwo = cost[0];
        for (int i = 2; i < n; i++) {
            int curr = Math.min(backOne, backTwo) + cost[i];
            backTwo = backOne;
            backOne = curr;
        }
        return Math.min(backOne, backTwo);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
