
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        if (2 * k + 1 > n) {
            return arr;
        }
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = k; i < n - k; i++) {
            int left = i - k;
            int right = i + k;
            int avg = (int) ((preSum[right + 1] - preSum[left]) / (2 * k + 1));
            arr[i] = avg;
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
