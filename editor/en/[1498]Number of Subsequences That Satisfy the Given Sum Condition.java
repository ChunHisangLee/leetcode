
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * 2 % MOD;
        }

        int count = 0;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + arr[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
