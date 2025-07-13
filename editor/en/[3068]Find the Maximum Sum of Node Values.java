// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long baseSum = 0L;
    long sumPos = 0L;
    int countPos = 0;
    int minAbs = Integer.MAX_VALUE;

    for (int num : nums) {
      baseSum += num;
      int diff = (num ^ k) - num;
      if (diff > 0) {
        sumPos += diff;
        countPos++;
      }
      minAbs = Math.min(minAbs, Math.abs(diff));
        }

    if (countPos % 2 == 0) {
      return baseSum + sumPos;
    }
    return baseSum + sumPos - minAbs;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
