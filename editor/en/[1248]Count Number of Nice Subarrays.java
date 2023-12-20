1248
        Count Number of Nice Subarrays
        2022-11-27 20:55:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCount(nums, k) - getCount(nums, k - 1);
    }

    private int getCount(int[] nums, int k) {
        int res = 0;
        int count = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            count += nums[right] % 2;
            while (count > k) {
                count -= nums[left] % 2;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
