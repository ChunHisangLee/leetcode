// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == '1') {
          count++;
          dfs(grid, r, c);
        }
      }
    }

    return count;
  }

  private void dfs(char[][] grid, int row, int col) {
    if (row < 0
        || row >= grid.length
        || col < 0
        || col >= grid[0].length
        || grid[row][col] != '1') {
      return;
    }

    grid[row][col] = '0';

    dfs(grid, row - 1, col);
    dfs(grid, row + 1, col);
    dfs(grid, row, col - 1);
    dfs(grid, row, col + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
