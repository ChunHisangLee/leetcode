
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] grid;
    int m;
    int n;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
