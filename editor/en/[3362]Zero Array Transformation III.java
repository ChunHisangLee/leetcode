// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public int maxRemoval(int[] nums, int[][] queries) {
    int n = nums.length;
    int m = queries.length;
    Interval[] intervals = new Interval[m];
    for (int i = 0; i < m; i++) {
      intervals[i] = new Interval(queries[i][0], queries[i][1]);
    }
    java.util.Arrays.sort(intervals, Comparator.comparingInt(a -> a.l));

    int[] diff = new int[n + 1];
    int selCount = 0;
    int idx = 0;
    long coverSoFar = 0;

    PriorityQueue<Interval> maxHeap =
        new PriorityQueue<>(Comparator.comparingInt((Interval it) -> it.r).reversed());

    for (int i = 0; i < n; i++) {
      while (idx < m && intervals[idx].l <= i) {
        maxHeap.offer(intervals[idx]);
        idx++;
      }
      coverSoFar += diff[i];

      while (coverSoFar < nums[i]) {
        while (!maxHeap.isEmpty() && maxHeap.peek().r < i) {
          maxHeap.poll();
        }
        if (maxHeap.isEmpty()) {
          return -1;
        }
        Interval best = maxHeap.poll();
        diff[best.l] += 1;
        if (best.r + 1 < diff.length) {
          diff[best.r + 1] -= 1;
        }
        selCount++;
        coverSoFar++;
      }
    }

    return m - selCount;
  }

  private static class Interval {
    int l, r;

    Interval(int l, int r) {
      this.l = l;
      this.r = r;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
