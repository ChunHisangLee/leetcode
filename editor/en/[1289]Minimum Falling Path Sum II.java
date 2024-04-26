//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                int value = grid[i - 1][j];

                if (value < min1) {
                    min2 = min1;
                    min1 = value;
                } else if (value < min2) {
                    min2 = value;
                }
            }

            for (int j = 0; j < n; j++) {
                if (grid[i - 1][j] == min1) {
                    grid[i][j] += min2;
                } else {
                    grid[i][j] += min1;
                }
            }
        }

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, grid[n - 1][i]);
        }

        return minSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
