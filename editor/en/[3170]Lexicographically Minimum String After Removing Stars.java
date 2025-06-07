// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public String clearStars(String s) {
    int n = s.length();
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
    boolean[] removed = new boolean[n];

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c != '*') {
        pq.offer(new int[] {c, i});
      } else {
        while (!pq.isEmpty() && removed[pq.peek()[1]]) {
          pq.poll();
        }
        if (!pq.isEmpty()) {
          removed[pq.poll()[1]] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c != '*' && !removed[i]) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
