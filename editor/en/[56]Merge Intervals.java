// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> result = new ArrayList<>();
    int[] current = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      int[] next = intervals[i];

      if (next[0] <= current[1]) {
        current[1] = Math.max(current[1], next[1]);
      } else {
        result.add(current);
        current = next;
      }
    }

    result.add(current);
    return result.toArray(new int[result.size()][]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
