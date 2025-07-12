// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point> maxHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(b.distance, a.distance));

    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      int distance = (x * x) + (y * y);

      Point dot = new Point(x, y, distance);

      if (maxHeap.size() < k) {
        maxHeap.offer(dot);
      } else {
        if (dot.distance < maxHeap.peek().distance) {
          maxHeap.poll();
          maxHeap.offer(dot);
        }
      }
    }

    List<int[]> list = new ArrayList<>();

    while (!maxHeap.isEmpty()) {
      Point dot = maxHeap.poll();
      list.add(new int[] {dot.x, dot.y});
    }

    return list.toArray(new int[list.size()][]);
  }

  class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
