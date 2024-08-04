//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MOD = (int) 1e9 + 7;
        int index = 0;
        int result = 0;
        int[] arr = new int[n * (n + 1) / 2];

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += nums[j];
                arr[index++] = sum;
            }
        }

        Arrays.sort(arr);

        for (int i = left - 1; i < right; i++) {
            result = (result + arr[i]) % MOD;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
