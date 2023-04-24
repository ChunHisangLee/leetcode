

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBall(int[][] grid) {
        int[] arr = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            arr[i] = dfs(grid, 0, i);
        }
        return arr;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i == grid.length) {
            return j;
        }
        int y = j + grid[i][j];
        if (y < 0 || y >= grid[0].length || grid[i][j] != grid[i][y]) {
            return -1;
        }
        return dfs(grid, i + 1, y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
