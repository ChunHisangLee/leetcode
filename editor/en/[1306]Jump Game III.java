
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean canReach(int[] arr, int start) {
    int n = arr.length;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();

    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      if (arr[curr] == 0) {
        return true;
      }

      int next = curr + arr[curr];
      if (next < n && !visited[next]) {
        visited[next] = true;
        queue.offer(next);
      }

      next = curr - arr[curr];
      if (next >= 0 && !visited[next]) {
        visited[next] = true;
        queue.offer(next);
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
