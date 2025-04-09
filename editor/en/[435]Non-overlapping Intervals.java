// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    int n = intervals.length;
    int end = intervals[0][1];
    int count = 1;

    for (int i = 0; i < n; i++) {
      if (intervals[i][0] >= end) {
        end = intervals[i][1];
        count++;
      }
    }

    return n-count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
