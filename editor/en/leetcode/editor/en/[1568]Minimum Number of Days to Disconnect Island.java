// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minDays(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    if (countIslands(grid) != 1) {
      return 0;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0;

          if (countIslands(grid) != 1) {
            return 1;
          }

          grid[i][j] = 1;
        }
      }
    }

    return 2;
  }

  private int countIslands(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          dfs(grid, visited, i, j);
          count++;
        }
      }
    }

    return count;
  }

  private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
    int m = grid.length;
    int n = grid[0].length;

    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
      return;
    }

    visited[x][y] = true;
    dfs(grid, visited, x + 1, y);
    dfs(grid, visited, x - 1, y);
    dfs(grid, visited, x, y + 1);
    dfs(grid, visited, x, y - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
