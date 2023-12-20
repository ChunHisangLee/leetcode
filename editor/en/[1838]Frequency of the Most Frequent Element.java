
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right;
        int result = 1;
        long sum = 0;
        Arrays.sort(nums);

        for (right = 0; right < nums.length; right++) {
            sum += nums[right];

            while ((long) (right - left + 1) * nums[right] - sum > k) {
                sum -= nums[left++];
            }

            result = Math.max(result, (right - left + 1));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
the key is to find out the valid condition:
k + sum >= size * max
 */