
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[100001];
        long sum = 0;
        long maxSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (freq[nums[right]] > 0) {
                freq[nums[left]]--;
                sum -= nums[left];
                left++;
            }

            freq[nums[right]]++;
            sum += nums[right];

            if (right - left + 1 > k) {
                freq[nums[left]]--;
                sum -= nums[left];
                left++;
            }

            if (right - left + 1 == k) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
