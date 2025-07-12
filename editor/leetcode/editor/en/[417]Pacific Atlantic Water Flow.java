// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int rows;
  private int cols;

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    if (heights == null || heights.length == 0 || heights[0].length == 0) {
      return Collections.emptyList();
    }

    rows = heights.length;
    cols = heights[0].length;

    boolean[][] pacificVisited = new boolean[rows][cols];
    boolean[][] atlanticVisited = new boolean[rows][cols];

    for (int r = 0; r < rows; r++) {
      dfs(heights, pacificVisited, r, 0);
    }
    for (int c = 0; c < cols; c++) {
      dfs(heights, pacificVisited, 0, c);
    }

    for (int r = 0; r < rows; r++) {
      dfs(heights, atlanticVisited, r, cols - 1);
    }
    for (int c = 0; c < cols; c++) {
      dfs(heights, atlanticVisited, rows - 1, c);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (pacificVisited[r][c] && atlanticVisited[r][c]) {
          result.add(List.of(r, c));
        }
      }
    }

    return result;
  }

  private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || reachable[r][c]) {
      return;
    }

    reachable[r][c] = true;

    for (int[] d : DIRS) {
      int nr = r + d[0];
      int nc = c + d[1];

      if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
        continue;
      }

      if (heights[nr][nc] >= heights[r][c]) {
        dfs(heights, reachable, nr, nc);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
