//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, findMaxGold(grid, i, j));
            }
        }

        return maxGold;
    }

    private int findMaxGold(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int current = grid[i][j];
        grid[i][j] = 0;
        int maxGold = 0;
        
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            maxGold = Math.max(maxGold, findMaxGold(grid, x, y));
        }

        grid[i][j] = current;
        return maxGold + current;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
