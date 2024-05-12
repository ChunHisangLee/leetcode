//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = getMax(grid, i, j);
            }
        }

        return maxLocal;
    }

    private int getMax(int[][] grid, int x, int y) {
        int maxValue = 0;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                maxValue = Math.max(maxValue, grid[i][j]);
            }
        }

        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
