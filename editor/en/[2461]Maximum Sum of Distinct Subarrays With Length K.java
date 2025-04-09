// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    int n = nums.length;
    long currSum = 0;
    long maxSum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;

    for (int right = 0; right < n; right++) {
      map.merge(nums[right], 1, Integer::sum);
      currSum += nums[right];

      if (right - left + 1 == k) {
        if (map.size() == k) {
          maxSum = Math.max(maxSum, currSum);
        }

        int count = map.get(nums[left]);

        if (count == 1) {
          map.remove(nums[left]);
        } else {
          map.put(nums[left], count - 1);
        }

        currSum -= nums[left];
        left++;
      }
    }

    return maxSum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
