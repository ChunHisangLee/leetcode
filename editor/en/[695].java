695
        Max Area of Island
        2023-03-02 10:42:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] grid;
    int m;
    int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 0;
            return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
