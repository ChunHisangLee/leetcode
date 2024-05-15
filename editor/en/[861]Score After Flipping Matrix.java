
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;

            for (int i = 0; i < m; i++) {
                count += grid[i][j];
            }

            if (2 * count < m) {
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            int rowSum = 0;

            for (int j = 0; j < n; j++) {
                rowSum = (rowSum << 1) | grid[i][j];
            }

            result += rowSum;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
