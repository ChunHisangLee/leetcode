// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maximumCount(int[] nums) {
    int negativeCount = 0;
    int positiveCount = 0;

    for (int num : nums) {
      if (num < 0) {
        negativeCount++;
      } else if (num > 0) {
        positiveCount++;
      }
    }

    return Math.max(negativeCount, positiveCount);
  }
}

// leetcode submit region end(Prohibit modification and deletion)
