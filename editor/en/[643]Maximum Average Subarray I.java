//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum;

        for (int i = k; i <= n - 1; i++) {
            sum += (nums[i] - nums[i - k]);
            max = Math.max(max, sum);
        }

        return max / k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
