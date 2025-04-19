// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    return countAtMost(nums, upper) - countAtMost(nums, lower - 1);
  }

  private long countAtMost(int[] nums, int bound) {
    long count = 0;
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      if (nums[left] + nums[right] <= bound) {
        count += (right - left);
        left++;
      } else {
        right--;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
