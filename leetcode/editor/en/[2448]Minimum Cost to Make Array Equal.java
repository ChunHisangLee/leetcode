
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    int[] cost;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        int val = binarySearch(0, (int) 1e6 + 1);
        return getCost(val);
    }

    private int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) >> 1;
            long cost1 = getCost(mid);
            long cost2 = getCost(mid + 1);
            if (cost1 > cost2) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long getCost(int val) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += 1L * Math.abs(nums[i] - val) * cost[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
