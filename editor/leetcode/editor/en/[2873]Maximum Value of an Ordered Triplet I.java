// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long maximumTripletValue(int[] nums) {
    long result = 0;
    int iMax = 0;
    int dMax = 0;

    for (int num : nums) {
      result = Math.max(result, (long) dMax * num);
      dMax = Math.max(dMax, iMax - num);
      iMax = Math.max(iMax, num);
    }

    return result;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
