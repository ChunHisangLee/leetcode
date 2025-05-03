// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxSubArray(int[] nums) {
    int bestSum = Integer.MIN_VALUE;
    int currSum = 0;

    for (int x : nums) {
      currSum += x;
      bestSum = Math.max(bestSum, currSum);

      if (currSum < 0) {
        currSum = 0;
      }
    }

    return bestSum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
