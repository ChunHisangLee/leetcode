// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxAbsoluteSum(int[] nums) {
    int sum = 0;
    int maxSum = 0;
    int minSum = 0;

    for (int num : nums) {
      sum += num;
      maxSum = Math.max(maxSum, sum);
      minSum = Math.min(minSum, sum);
    }

    return maxSum - minSum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
