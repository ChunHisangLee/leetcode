// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxAscendingSum(int[] nums) {
    int n = nums.length;
    int maxSum = nums[0];
    int currentSum = nums[0];

    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        currentSum += nums[i];
      } else {
        maxSum = Math.max(maxSum, currentSum);
        currentSum = nums[i];
      }
    }

    return Math.max(maxSum, currentSum);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
