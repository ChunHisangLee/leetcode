// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> maxHeap =
        new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

    for (int[] point : points) {
      maxHeap.offer(point);

      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    return maxHeap.toArray(new int[k][]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
