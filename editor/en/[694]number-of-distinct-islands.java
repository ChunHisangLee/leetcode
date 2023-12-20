694
Number of Distinct Islands
2023-03-02 10:41:36
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] grid;
    private boolean[][] isVisited;
    private StringBuilder currentIsland;

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        this.isVisited = new boolean[grid.length][grid[0].length];
        Set<String> islands = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                currentIsland = new StringBuilder();
                dfs(row, col, '0');
                if (currentIsland.length() == 0) {
                    continue;
                }
                islands.add(currentIsland.toString());
            }
        }
        return islands.size();
    }

    private void dfs(int row, int col, char dir) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if (isVisited[row][col] || grid[row][col] == 0) return;
        isVisited[row][col] = true;
        currentIsland.append(dir);
        dfs(row + 1, col, 'D');
        dfs(row - 1, col, 'U');
        dfs(row, col + 1, 'R');
        dfs(row, col - 1, 'L');
        currentIsland.append('0');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
