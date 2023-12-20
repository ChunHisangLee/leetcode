
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getMost(nums, k) - getMost(nums, k - 1);
    }

    private int getMost(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int count = 0;
        int[] arr = new int[n + 1];
        for (int left = 0, right = 0; right < n; right++) {
            if (arr[nums[right]] == 0) {
                count++;
            }
            arr[nums[right]]++;
            while (count > k) {
                arr[nums[left]]--;
                if (arr[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
