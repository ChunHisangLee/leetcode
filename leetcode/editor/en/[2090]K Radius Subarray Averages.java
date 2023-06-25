
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        if (2 * k + 1 > n) {
            return arr;
        }
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = k; i < n - k; i++) {
            int left = i - k;
            int right = i + k;
            arr[i] = (int) ((prefixSum[right + 1] - prefixSum[left]) / (2 * k + 1));
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
