
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m;
    int n;
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAtl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, isPac);
            dfs(i, n - 1, isAtl);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, isPac);
            dfs(m - 1, i, isAtl);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPac[i][j] && isAtl[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, boolean[][] isVisited) {
        isVisited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
                continue;
            }
            if (heights[x][y] < heights[i][j]) {
                continue;
            }
            dfs(x, y, isVisited);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
