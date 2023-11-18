
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while ((long) (right - left + 1) * nums[right] - sum > k) {
                sum -= nums[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
