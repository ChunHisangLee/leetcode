
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, long k) {
    long count = 0L;
    long sum = 0L;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];

      while (left <= right && sum * (right - left + 1L) >= k) {
        sum -= nums[left++];
      }

      count += (right - left + 1);
    }

    return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
