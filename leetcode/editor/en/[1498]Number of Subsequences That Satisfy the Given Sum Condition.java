
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = n - 1;
        int mod = (int) 1e9 + 7;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * 2 % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                res = (res + arr[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
