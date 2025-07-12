// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    long prefix = 0;
    long minPrefix = 0;
    long maxPrefix = 0;

    for (int diff : differences) {
      prefix += diff;
      minPrefix = Math.min(minPrefix, prefix);
      maxPrefix = Math.max(maxPrefix, prefix);
    }

    long left = lower - minPrefix;
    long right = upper - maxPrefix;

    return (int) Math.max(0, right - left + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
