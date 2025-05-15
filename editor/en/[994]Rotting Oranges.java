//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int freshCount = 0;
    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new int[] {i, j});
        } else if (grid[i][j] == 1) {
          freshCount++;
        }
      }
    }

    if (freshCount == 0) {
      return 0;
    }

    int minutes = 0;

    while (!queue.isEmpty() && freshCount > 0) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] curr = queue.poll();

        for (int[] d : DIRS) {
          int x = curr[0] + d[0];
          int y = curr[1] + d[1];

          if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
            continue;
          }

          grid[x][y] = 2;
          freshCount--;
          queue.offer(new int[] {x, y});
        }
      }

      minutes++;
    }

    return freshCount == 0 ? minutes : -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
