
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] isVisited;
    int m;
    int n;
    int count;

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    isVisited[i][j] = true;
                    dfs(grid, i, j);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }

        return max;
    }

    public void dfs(int[][] grid, int i, int j) {
        count += grid[i][j];

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || isVisited[x][y]) {
                continue;
            }

            isVisited[x][y] = true;
            dfs(grid, x, y);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
