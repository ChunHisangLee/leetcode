// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> list = new ArrayList<>();
    int[] currInterval = intervals[0];

    for (int[] interval : intervals) {
      if (interval[0] <= currInterval[1]) {
        currInterval[1] = Math.max(currInterval[1], interval[1]);
      } else {
        list.add(currInterval);
        currInterval = interval;
      }
    }

    list.add(currInterval);
    return list.toArray(new int[list.size()][]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
