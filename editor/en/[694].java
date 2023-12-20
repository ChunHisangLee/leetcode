694
        Number of Distinct Islands
        2023-03-02 11:21:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] grid;
    int m;
    int n;
    StringBuilder sb;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sb = new StringBuilder();
                    dfs(i, j, '0');
                    if (sb.length() != 0) {
                        set.add(sb.toString());
                    }
                }
            }
        }
        return set.size();
    }

    private void dfs(int x, int y, char dir) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 0;
            sb.append(dir);
            dfs(x + 1, y, 'D');
            dfs(x - 1, y, 'U');
            dfs(x, y + 1, 'R');
            dfs(x, y - 1, 'L');
            sb.append('0');
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
