//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
    long count = 0L;
    int lastMinPosition = -1;
    int lastMaxPosition = -1;
    int lastInvalidPosition = -1;

    for (int i = 0; i < nums.length; i++) {
      int v = nums[i];

      if (v < minK || v > maxK) {
        lastInvalidPosition = i;
            }
      if (v == minK) {
        lastMinPosition = i;
            }
      if (v == maxK) {
        lastMaxPosition = i;
      }

      int validStartCount = Math.min(lastMinPosition, lastMaxPosition) - lastInvalidPosition;
      if (validStartCount > 0) {
        count += validStartCount;
      }
    }
    return count;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
