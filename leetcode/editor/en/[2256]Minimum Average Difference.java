2256
        Minimum Average Difference
        2022-12-04 16:21:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int min = Integer.MAX_VALUE;
        long prefixSum = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            long leftPart = prefixSum / (i + 1);
            long rightPart = total - prefixSum;
            if (i != n - 1) {
                rightPart /= (n - (i + 1));
            }
            int currDiff = (int) Math.abs(leftPart - rightPart);
            if (currDiff < min) {
                min = currDiff;
                ans = i;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
