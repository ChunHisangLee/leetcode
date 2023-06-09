
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] heights;
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAtl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, isPac);
            dfs(i, n - 1, isAtl);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, isPac);
            dfs(m - 1, j, isAtl);
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

    public void dfs(int i, int j, boolean[][] isVisited) {
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
