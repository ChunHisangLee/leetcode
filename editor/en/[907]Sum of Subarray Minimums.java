
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int n = arr.length;
        int[] left = new int[n];
        int[] sum = new int[n + 1];
        int result = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int leftIndex = i - 1;

            while (leftIndex >= 0 && arr[leftIndex] >= curr) {
                leftIndex = left[leftIndex];
            }

            left[i] = leftIndex;
            sum[i + 1] = (sum[leftIndex + 1] + curr * (i - leftIndex)) % MOD;
            result = (result + sum[i + 1]) % MOD;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
