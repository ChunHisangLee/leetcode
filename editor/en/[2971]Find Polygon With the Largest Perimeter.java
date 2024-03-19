//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = n - 1; i > 1; i--) {
            if (nums[i] < prefixSum[i - 1]) {
                return prefixSum[i];
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
