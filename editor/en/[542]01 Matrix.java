
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] dist = new int[m][n];
    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          dist[i][j] = 0;
          queue.offer(new int[] {i, j});
        } else {
          dist[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int r = curr[0];
      int c = curr[1];

      for (int[] dir : DIRS) {
        int nr = r + dir[0];
        int nc = c + dir[1];

        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
          if (dist[nr][nc] > dist[r][c] + 1) {
            dist[nr][nc] = dist[r][c] + 1;
            queue.offer(new int[] {nr, nc});
          }
        }
      }
    }

    return dist;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
